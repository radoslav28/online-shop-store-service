package com.onlineshop.store.core.processors.item;

import com.onlineshop.store.api.operations.item.archive.ArchiveItemInput;
import com.onlineshop.store.api.operations.item.archive.ArchiveItemOperation;
import com.onlineshop.store.api.operations.item.archive.ArchiveItemResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArchiveItemCore implements ArchiveItemOperation {
    @Override
    public ArchiveItemResult process(ArchiveItemInput input) {
        return null;
    }
}
