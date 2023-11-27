package com.onlineshop.store.core.processors.item;

import com.onlineshop.store.api.operations.item.create.CreateItemInput;
import com.onlineshop.store.api.operations.item.create.CreateItemOperation;
import com.onlineshop.store.api.operations.item.create.CreateItemResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateItemCore implements CreateItemOperation {
    @Override
    public CreateItemResult process(CreateItemInput input) {
        return null;
    }
}
