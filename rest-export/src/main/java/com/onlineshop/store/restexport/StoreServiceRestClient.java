package com.onlineshop.store.restexport;

import com.onlineshop.store.api.operations.item.archive.ArchiveItemResult;
import com.onlineshop.store.api.operations.item.changetags.ChangeItemTagsInput;
import com.onlineshop.store.api.operations.item.changetags.ChangeItemTagsResult;
import com.onlineshop.store.api.operations.item.create.CreateItemInput;
import com.onlineshop.store.api.operations.item.create.CreateItemResult;
import com.onlineshop.store.api.operations.item.get.all.GetItemsResult;
import com.onlineshop.store.api.operations.item.get.byid.GetItemByIdResult;
import com.onlineshop.store.api.operations.item.get.byIds.GetItemsByIdsResult;
import com.onlineshop.store.api.operations.item.get.bytag.GetItemsByTagResult;
import com.onlineshop.store.api.operations.item.update.UpdateItemInput;
import com.onlineshop.store.api.operations.item.update.UpdateItemResult;
import com.onlineshop.store.api.operations.multimedia.AddMultimediaToItemInput;
import com.onlineshop.store.api.operations.multimedia.AddMultimediaToItemResult;
import com.onlineshop.store.api.operations.tag.create.CreateTagInput;
import com.onlineshop.store.api.operations.tag.create.CreateTagResult;
import com.onlineshop.store.api.operations.tag.getall.GetTagsResult;
import com.onlineshop.store.api.operations.vendor.create.CreateVendorInput;
import com.onlineshop.store.api.operations.vendor.create.CreateVendorResult;
import com.onlineshop.store.api.operations.vendor.getall.GetVendorsResult;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

@Headers({"Content-Type: application/json"})
public interface StoreServiceRestClient {

    @RequestLine("POST /items")
    CreateItemResult createItem (CreateItemInput input);

    @RequestLine("GET /items/{itemId}")
    GetItemByIdResult getItem (@Param("itemId") String itemId);

    @RequestLine("GET /items")
    GetItemsResult getItems ();

    @RequestLine("GET /items/tag?tagId{tagId}")
    GetItemsByTagResult getItemsByTag (@Param("tagId") String tagId);

    @RequestLine("GET /items/by_ids?itemsIds={itemsIds}")
    GetItemsByIdsResult getItemsByIds (@Param("itemsIds") List<String> itemsIds);

    @RequestLine("PUT /items")
    UpdateItemResult updateItem (UpdateItemInput input);

    @Headers({"Content-Type: application/json-patch+json"})
    @RequestLine("PATCH /items/tags")
    ChangeItemTagsResult changeItemTags (ChangeItemTagsInput input);

    @RequestLine("POST /items/archive?itemId={itemId}")
    ArchiveItemResult archiveItem (@Param("itemId") String itemId);

    @RequestLine("POST /tags")
    CreateTagResult createTag (CreateTagInput input);

    @RequestLine("GET /tags")
    GetTagsResult getTags ();

    @RequestLine("POST /vendors")
    CreateVendorResult createVendor (CreateVendorInput input);
    @RequestLine("GET /vendors")
    GetVendorsResult getVendors();

    @RequestLine("POST /multimedia")
    AddMultimediaToItemResult addMultimediaToItem(AddMultimediaToItemInput input);

}
