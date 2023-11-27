package com.onlineshop.store.rest.controllers;

import com.onlineshop.store.api.operations.multimedia.addtoitem.AddMultimediaToItemInput;
import com.onlineshop.store.api.operations.multimedia.addtoitem.AddMultimediaToItemOperation;
import com.onlineshop.store.api.operations.multimedia.addtoitem.AddMultimediaToItemResult;
import com.onlineshop.store.api.operations.multimedia.getbyitem.GetMultimediaByItemInput;
import com.onlineshop.store.api.operations.multimedia.getbyitem.GetMultimediaByItemOperation;
import com.onlineshop.store.api.operations.multimedia.getbyitem.GetMultimediaByItemResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.UUID;
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
    private final GetMultimediaByItemOperation getMultimediaByItem;

    @Operation(summary = "Add multimedia to item", description = "Add multimedia to item")
    @PostMapping
    public ResponseEntity<AddMultimediaToItemResult> addMultimediaToItem (@RequestBody @Valid AddMultimediaToItemInput input) {

        return new ResponseEntity<>(addMultimediaToItem.process(input), HttpStatus.OK);
    }

    @Operation(summary = "Get multimedia for item", description = "Return all multimedia for item")
    @GetMapping
    public ResponseEntity<GetMultimediaByItemResult> getMultimediaByItem (@RequestParam @UUID String itemId) {

        GetMultimediaByItemInput input = GetMultimediaByItemInput
                .builder()
                .itemId(itemId)
                .build();

        return new ResponseEntity<>(getMultimediaByItem.process(input), HttpStatus.OK);
    }

}
