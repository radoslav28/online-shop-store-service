package com.onlineshop.store.core.processors.tag;

import com.onlineshop.store.api.exceptions.ServiceUnavailableException;
import com.onlineshop.store.api.model.TagModel;
import com.onlineshop.store.api.operations.tag.getall.GetTagsInput;
import com.onlineshop.store.api.operations.tag.getall.GetTagsOperation;
import com.onlineshop.store.api.operations.tag.getall.GetTagsResult;
import com.onlineshop.store.persistence.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetTagsCore implements GetTagsOperation {

    private final TagRepository tagRepository;
    private final ConversionService conversionService;

    @Override
    public GetTagsResult process(GetTagsInput input) {

        try {

            return GetTagsResult
                    .builder()
                    .tagModels(tagRepository
                            .findAll()
                            .stream()
                            .map(t -> conversionService.convert(t, TagModel.class))
                            .toList())
                    .build();

        } catch (JDBCConnectionException e) {
            throw new ServiceUnavailableException();
        }
    }
}
