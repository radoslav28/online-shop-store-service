package com.onlineshop.store.core.processors.tag;

import com.onlineshop.store.api.operations.tag.getall.GetTagsInput;
import com.onlineshop.store.api.operations.tag.getall.GetTagsOperation;
import com.onlineshop.store.api.operations.tag.getall.GetTagsResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetTagsCore implements GetTagsOperation {
    @Override
    public GetTagsResult process(GetTagsInput input) {
        return null;
    }
}
