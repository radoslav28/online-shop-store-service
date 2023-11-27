package com.onlineshop.store.rest.controllers;

import com.onlineshop.store.api.operations.item.archive.ArchiveItemInput;
import com.onlineshop.store.api.operations.item.archive.ArchiveItemOperation;
import com.onlineshop.store.api.operations.item.archive.ArchiveItemResult;
import com.onlineshop.store.api.operations.item.changetags.ChangeItemTagsInput;
import com.onlineshop.store.api.operations.item.changetags.ChangeItemTagsOperation;
import com.onlineshop.store.api.operations.item.changetags.ChangeItemTagsResult;
import com.onlineshop.store.api.operations.item.create.CreateItemInput;
import com.onlineshop.store.api.operations.item.create.CreateItemOperation;
import com.onlineshop.store.api.operations.item.create.CreateItemResult;
import com.onlineshop.store.api.operations.item.get.all.GetItemsInput;
import com.onlineshop.store.api.operations.item.get.all.GetItemsOperation;
import com.onlineshop.store.api.operations.item.get.all.GetItemsResult;
import com.onlineshop.store.api.operations.item.get.byid.GetItemByIdInput;
import com.onlineshop.store.api.operations.item.get.byid.GetItemByIdOperation;
import com.onlineshop.store.api.operations.item.get.byid.GetItemByIdResult;
import com.onlineshop.store.api.operations.item.get.byIds.GetItemsByIdsInput;
import com.onlineshop.store.api.operations.item.get.byIds.GetItemsByIdsOperation;
import com.onlineshop.store.api.operations.item.get.byIds.GetItemsByIdsResult;
import com.onlineshop.store.api.operations.item.get.bytag.GetItemsByTagInput;
import com.onlineshop.store.api.operations.item.get.bytag.GetItemsByTagOperation;
import com.onlineshop.store.api.operations.item.get.bytag.GetItemsByTagResult;
import com.onlineshop.store.api.operations.item.update.UpdateItemInput;
import com.onlineshop.store.api.operations.item.update.UpdateItemOperation;
import com.onlineshop.store.api.operations.item.update.UpdateItemResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@Tag(name = "Items Controller")
@RequiredArgsConstructor
@Validated
public class ItemController {

    private final CreateItemOperation createItem;
    private final GetItemByIdOperation getItemById;
    private final GetItemsOperation getItems;
    private final GetItemsByIdsOperation getItemsByIds;
    private final GetItemsByTagOperation getItemsByTag;
    private final UpdateItemOperation updateItem;
    private final ChangeItemTagsOperation changeItemTags;
    private final ArchiveItemOperation archiveItem;

    @Operation(summary = "Add item", description = "Add item and return it")
    @PostMapping
    public ResponseEntity<CreateItemResult> createItem(@RequestBody @Valid CreateItemInput input) {

        return new ResponseEntity<>(createItem.process(input), HttpStatus.CREATED);
    }

    @Operation(summary = "Get item", description = "Return item")
    @GetMapping("/{itemId}")
    public ResponseEntity<GetItemByIdResult> getItemById(@PathVariable @UUID String itemId) {

        GetItemByIdInput input = GetItemByIdInput
                .builder()
                .itemId(itemId)
                .build();

        return new ResponseEntity<>(getItemById.process(input), HttpStatus.OK);
    }

    @Operation(summary = "Get items by ids", description = "Get items by ids")
    @GetMapping("/by_ids")
    public ResponseEntity<GetItemsByIdsResult> getItemsByIds(@RequestParam List<@UUID String> itemsIds) {

        GetItemsByIdsInput input = GetItemsByIdsInput
                .builder()
                .itemsIds(itemsIds)
                .build();

        return new ResponseEntity<>(getItemsByIds.process(input), HttpStatus.OK);
    }

    @Operation(summary = "Get all items", description = "Return list with all items")
    @GetMapping
    public ResponseEntity<GetItemsResult> getItems() {

        return new ResponseEntity<>(getItems.process(new GetItemsInput()), HttpStatus.OK);
    }

    @Operation(summary = "Get items by tag", description = "Return list with all items with this tag")
    @GetMapping("/tag/{tagId}")
    public ResponseEntity<GetItemsByTagResult> getItemsByTag (@RequestParam @UUID String tagId) {

        GetItemsByTagInput input = GetItemsByTagInput
                .builder()
                .tagId(tagId)
                .build();

        return new ResponseEntity<>(getItemsByTag.process(input), HttpStatus.OK);
    }

    @Operation(summary = "Update item", description = "Return updated item")
    @PutMapping
    public ResponseEntity<UpdateItemResult> updateItem (@RequestBody @Valid UpdateItemInput input) {

        return new ResponseEntity<>(updateItem.process(input), HttpStatus.OK);
    }

    @Operation(summary = "Change item's tags", description = "Update tags of item")
    @PatchMapping(value = "/tags", consumes = "application/json-patch+json")
    public ResponseEntity<ChangeItemTagsResult> changeItemsTags(@RequestBody @Valid ChangeItemTagsInput input) {

        return new ResponseEntity<>(changeItemTags.process(input), HttpStatus.OK);
    }

    @Operation(summary = "Archive item", description = "Setting item's isAvailable field to false")
    @PostMapping("/archive")
    public ResponseEntity<ArchiveItemResult> archiveItem (@RequestParam @UUID String itemId) {

        ArchiveItemInput input = ArchiveItemInput
                .builder()
                .itemId(itemId)
                .build();

        return new ResponseEntity<>(archiveItem.process(input), HttpStatus.OK);
    }
}
