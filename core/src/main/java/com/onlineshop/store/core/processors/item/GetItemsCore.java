package com.onlineshop.store.core.processors.item;

import com.onlineshop.store.api.operations.item.getall.GetItemsInput;
import com.onlineshop.store.api.operations.item.getall.GetItemsOperation;
import com.onlineshop.store.api.operations.item.getall.GetItemsResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetItemsCore implements GetItemsOperation {
    @Override
    public GetItemsResult process(GetItemsInput input) {
        return null;
    }
}
