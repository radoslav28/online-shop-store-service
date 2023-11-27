package com.onlineshop.store.core.processors.item;

import com.onlineshop.store.api.operations.item.getbytag.GetItemsByTagInput;
import com.onlineshop.store.api.operations.item.getbytag.GetItemsByTagOperation;
import com.onlineshop.store.api.operations.item.getbytag.GetItemsByTagResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetItemsByTagCore implements GetItemsByTagOperation {
    @Override
    public GetItemsByTagResult process(GetItemsByTagInput input) {
        return null;
    }
}
