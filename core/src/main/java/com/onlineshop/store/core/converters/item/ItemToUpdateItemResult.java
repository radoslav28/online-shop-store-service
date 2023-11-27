package com.onlineshop.store.core.converters.item;

import com.onlineshop.store.api.model.MultimediaModel;
import com.onlineshop.store.api.model.TagModel;
import com.onlineshop.store.api.model.VendorModel;
import com.onlineshop.store.api.operations.item.update.UpdateItemResult;
import com.onlineshop.store.persistence.entities.Item;
import com.onlineshop.store.persistence.entities.Multimedia;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ItemToUpdateItemResult implements Converter<Item, UpdateItemResult> {

    private final ConversionService conversionService;

    @Lazy
    public ItemToUpdateItemResult(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public UpdateItemResult convert(Item source) {
        return UpdateItemResult
                .builder()
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
