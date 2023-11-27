package com.onlineshop.store.core.processors.tag;

import com.onlineshop.store.api.exceptions.ServiceUnavailableException;
import com.onlineshop.store.api.operations.tag.create.CreateTagInput;
import com.onlineshop.store.api.operations.tag.create.CreateTagOperation;
import com.onlineshop.store.api.operations.tag.create.CreateTagResult;
import com.onlineshop.store.persistence.entities.Tag;
import com.onlineshop.store.persistence.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTagCore implements CreateTagOperation {

    private final TagRepository tagRepository;
    private final ConversionService conversionService;

    @Override
    public CreateTagResult process(CreateTagInput input) {

        try {

            Tag tag = Tag
                    .builder()
                    .title(input.getTitle())
                    .build();

            Tag persisted = tagRepository.save(tag);

            return CreateTagResult
                    .builder()
                    .id(String.valueOf(persisted.getId()))
                    .build();

        } catch (JDBCConnectionException e) {
            throw new ServiceUnavailableException();
        }
    }
}
