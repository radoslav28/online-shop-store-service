package com.onlineshop.store.core.converters.item;

import com.onlineshop.store.api.model.MultimediaModel;
import com.onlineshop.store.api.model.TagModel;
import com.onlineshop.store.api.model.VendorModel;
import com.onlineshop.store.api.operations.item.getbyid.GetItemByIdResult;
import com.onlineshop.store.persistence.entities.Item;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ItemToGetItemByIdResult implements Converter<Item, GetItemByIdResult> {

    private final ConversionService conversionService;

    @Lazy
    public ItemToGetItemByIdResult(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public GetItemByIdResult convert(Item source) {
        return GetItemByIdResult.builder()
                .id(String.valueOf(source.getId()))
                .title(source.getTitle())
                .description(source.getDescription())
                .vendorModel(conversionService.convert(source.getVendor(), VendorModel.class))
                .multimediaModels(source
                        .getMultimedia()
                        .stream()
                        .map(m -> conversionService.convert(m, MultimediaModel.class))
                        .toList())
                .tagModels(source
                        .getTags()
                        .stream()
                        .map(t -> conversionService.convert(t, TagModel.class))
                        .toList())
                .build();
    }
}
