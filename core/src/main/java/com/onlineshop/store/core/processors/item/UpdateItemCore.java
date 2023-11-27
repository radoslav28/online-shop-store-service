package com.onlineshop.store.core.processors.item;

import com.onlineshop.store.api.operations.item.update.UpdateItemInput;
import com.onlineshop.store.api.operations.item.update.UpdateItemOperation;
import com.onlineshop.store.api.operations.item.update.UpdateItemResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateItemCore implements UpdateItemOperation {
    @Override
    public UpdateItemResult process(UpdateItemInput input) {
        return null;
    }
}
