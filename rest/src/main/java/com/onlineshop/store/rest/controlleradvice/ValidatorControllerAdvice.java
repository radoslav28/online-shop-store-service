package com.onlineshop.store.rest.controlleradvice;

import com.onlineshop.store.api.exceptions.DisallowedIdException;
import com.onlineshop.store.api.exceptions.ServiceUnavailableException;
import com.onlineshop.store.rest.controllers.ItemController;
import com.onlineshop.store.rest.controllers.MultimediaController;
import com.onlineshop.store.rest.controllers.TagController;
import com.onlineshop.store.rest.controllers.VendorController;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(basePackageClasses = {
        ItemController.class,
        TagController.class,
        MultimediaController.class,
        VendorController.class
})
@RequiredArgsConstructor
public class ValidatorControllerAdvice {

    private final ErrorPrinter errorPrinter;

    @ExceptionHandler({
            HttpMessageNotReadableException.class
    })
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {

        InvalidInput input = new InvalidInput();
        input.addMessage("Not a valid JSON.");

        return errorPrinter.getErrorList(input);
    }

    @ExceptionHandler({
            ServiceUnavailableException.class
    })
    @ResponseBody
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public String handleServiceUnavailableException(ServiceUnavailableException e) {

        InvalidInput input = new InvalidInput();
        input.addMessage(e.getMessage());

        return errorPrinter.getErrorList(input);
    }

    @ExceptionHandler({
            MethodArgumentNotValidException.class
    })
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        InvalidInput input = new InvalidInput();

        e.getAllErrors()
                .stream()
                .map(this.errorPrinter::mapErrorToMessage)
                .forEach(input::addMessage);

        return errorPrinter.getErrorList(input);
    }

    @ExceptionHandler({
            ConstraintViolationException.class
    })
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleConstraintViolationException(ConstraintViolationException e) {

        InvalidInput input = new InvalidInput();

        e.getConstraintViolations()
                .stream()
                .map(this::parseConstraintViolation)
                .forEach(input::addMessage);

        return errorPrinter.getErrorList(input);
    }

    @ExceptionHandler({
            IllegalArgumentException.class
    })
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidEnumsDataException(Exception e) {
        InvalidInput input = new InvalidInput();

        input.addMessage(e.getMessage());

        return errorPrinter.getErrorList(input);
    }

    @ExceptionHandler({
            DisallowedIdException.class
    })
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException(Exception e) {
        InvalidInput input = new InvalidInput();

        input.addMessage(e.getMessage());

        return errorPrinter.getErrorList(input);
    }

    @ExceptionHandler({
            UnsupportedOperationException.class,
    })
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleInvalidConversionException(Exception e) {
        InvalidInput input = new InvalidInput();

        input.addMessage(e.getMessage());

        return errorPrinter.getErrorList(input);
    }

    private String parseConstraintViolation(ConstraintViolation<?> violation) {
        String path = violation.getPropertyPath().toString();
        String field = path.substring(path.indexOf('.') + 1);
        String message = violation.getMessage();

        if (violation.getMessageTemplate().startsWith("{jakarta.validation.constraints.") && violation.getMessageTemplate().endsWith("message}")) {
            return field + " " + message;
        }

        return message;

    }
}
