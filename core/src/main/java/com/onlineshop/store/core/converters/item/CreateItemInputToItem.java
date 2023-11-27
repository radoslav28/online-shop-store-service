package com.onlineshop.store.core.converters.item;

import com.onlineshop.store.api.operations.item.create.CreateItemInput;
import com.onlineshop.store.persistence.entities.Item;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CreateItemInputToItem implements Converter<CreateItemInput, Item> {
    @Override
    public Item convert(CreateItemInput source) {
        return Item
                .builder()
                .title(source.getTitle())
                .description(source.getDescription())
                .multimedia(new ArrayList<>())
                .build();
    }
}
