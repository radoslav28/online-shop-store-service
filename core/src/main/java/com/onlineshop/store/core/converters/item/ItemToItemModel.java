package com.onlineshop.store.core.converters.item;

import com.onlineshop.store.api.model.ItemModel;
import com.onlineshop.store.api.model.MultimediaModel;
import com.onlineshop.store.api.model.TagModel;
import com.onlineshop.store.api.model.VendorModel;
import com.onlineshop.store.persistence.entities.Item;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ItemToItemModel implements Converter<Item, ItemModel> {
    private final ConversionService conversionService;

    @Lazy
    public ItemToItemModel(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public ItemModel convert(Item source) {
        return ItemModel
                .builder()
                .id(String.valueOf(source.getId()))
                .title(source.getTitle())
                .description(source.getDescription())
                .vendor(conversionService.convert(source.getVendor(), VendorModel.class))
                .multimedia(source
                        .getMultimedia()
                        .stream()
                        .map(m -> conversionService.convert(m, MultimediaModel.class))
                        .toList())
                .tags(source
                        .getTags()
                        .stream()
                        .map(t -> conversionService.convert(t, TagModel.class))
                        .toList())
                .build();
    }
}
