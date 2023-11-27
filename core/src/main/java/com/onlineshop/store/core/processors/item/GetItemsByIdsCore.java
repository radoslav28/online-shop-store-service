package com.onlineshop.store.core.processors.item;

import com.onlineshop.store.api.operations.item.getbyids.GetItemsByIdsInput;
import com.onlineshop.store.api.operations.item.getbyids.GetItemsByIdsOperation;
import com.onlineshop.store.api.operations.item.getbyids.GetItemsByIdsResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetItemsByIdsCore implements GetItemsByIdsOperation {
    @Override
    public GetItemsByIdsResult process(GetItemsByIdsInput input) {
        return null;
    }
}
