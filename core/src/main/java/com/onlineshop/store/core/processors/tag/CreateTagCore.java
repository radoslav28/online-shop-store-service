package com.onlineshop.store.core.processors.tag;

import com.onlineshop.store.api.operations.tag.create.CreateTagInput;
import com.onlineshop.store.api.operations.tag.create.CreateTagOperation;
import com.onlineshop.store.api.operations.tag.create.CreateTagResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTagCore implements CreateTagOperation {
    @Override
    public CreateTagResult process(CreateTagInput input) {
        return null;
    }
}
