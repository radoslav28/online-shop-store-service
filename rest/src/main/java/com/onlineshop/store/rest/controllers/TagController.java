package com.onlineshop.store.rest.controllers;

import com.onlineshop.store.api.operations.tag.create.CreateTagInput;
import com.onlineshop.store.api.operations.tag.create.CreateTagOperation;
import com.onlineshop.store.api.operations.tag.create.CreateTagResult;
import com.onlineshop.store.api.operations.tag.getall.GetTagsInput;
import com.onlineshop.store.api.operations.tag.getall.GetTagsOperation;
import com.onlineshop.store.api.operations.tag.getall.GetTagsResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tags")
@Tag(name = "Tags Controller")
@RequiredArgsConstructor
@Validated
public class TagController {

    private final CreateTagOperation createTag;
    private final GetTagsOperation getTags;

    @PostMapping
    @Operation(summary = "Create tag", description = "Create tag and return its id")
    public ResponseEntity<CreateTagResult> createTag (@RequestBody @Valid CreateTagInput input) {

        return new ResponseEntity<>(createTag.process(input), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all tags", description = "Get all tags")
    public ResponseEntity<GetTagsResult> getTags () {

        return new ResponseEntity<>(getTags.process(new GetTagsInput()), HttpStatus.OK);
    }
}
