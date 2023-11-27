package com.onlineshop.store.rest.controllers;

import com.onlineshop.store.api.operations.multimedia.AddMultimediaToItemInput;
import com.onlineshop.store.api.operations.multimedia.AddMultimediaToItemOperation;
import com.onlineshop.store.api.operations.multimedia.AddMultimediaToItemResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/multimedia")
@Tag(name = "Multimedia Controller")
@RequiredArgsConstructor
@Validated
public class MultimediaController {

    private final AddMultimediaToItemOperation addMultimediaToItem;

    @Operation(summary = "Add multimedia to item", description = "Add multimedia to item")
    @PostMapping
    public ResponseEntity<AddMultimediaToItemResult> addMultimediaToItem (@RequestBody @Valid AddMultimediaToItemInput input) {

        return new ResponseEntity<>(addMultimediaToItem.process(input), HttpStatus.OK);
    }

}
