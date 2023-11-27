package com.onlineshop.store.core.converters.tag;

import com.onlineshop.store.api.model.TagModel;
import com.onlineshop.store.persistence.entities.Tag;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TagToTagModel implements Converter<Tag, TagModel> {
    @Override
    public TagModel convert(Tag source) {
        return TagModel
                .builder()
                .id(String.valueOf(source.getId()))
                .title(source.getTitle())
                .build();
    }
}
