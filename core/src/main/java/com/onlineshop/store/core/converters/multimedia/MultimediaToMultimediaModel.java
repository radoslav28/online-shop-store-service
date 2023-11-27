package com.onlineshop.store.core.converters.multimedia;

import com.onlineshop.store.api.model.MultimediaModel;
import com.onlineshop.store.persistence.entities.Multimedia;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MultimediaToMultimediaModel implements Converter<Multimedia, MultimediaModel> {
    @Override
    public MultimediaModel convert(Multimedia source) {
        return MultimediaModel
                .builder()
                .id(String.valueOf(source.getId()))
                .url(source.getUrl())
                .build();
    }
}
