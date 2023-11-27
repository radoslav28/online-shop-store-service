package com.onlineshop.store.core.processors.item;

import com.onlineshop.store.api.operations.item.changetags.ChangeItemTagsInput;
import com.onlineshop.store.api.operations.item.changetags.ChangeItemTagsOperation;
import com.onlineshop.store.api.operations.item.changetags.ChangeItemTagsResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangeItemTagsCore implements ChangeItemTagsOperation {
    @Override
    public ChangeItemTagsResult process(ChangeItemTagsInput input) {
        return null;
    }
}
