package com.onlineshop.store.core.processors.item;

import com.onlineshop.store.api.operations.item.getbyid.GetItemByIdInput;
import com.onlineshop.store.api.operations.item.getbyid.GetItemByIdOperation;
import com.onlineshop.store.api.operations.item.getbyid.GetItemByIdResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetItemByIdCore implements GetItemByIdOperation {
    @Override
    public GetItemByIdResult process(GetItemByIdInput input) {
        return null;
    }
}
