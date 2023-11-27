package com.onlineshop.store.core.processors.multimedia;

import com.onlineshop.store.api.operations.multimedia.addtoitem.AddMultimediaToItemInput;
import com.onlineshop.store.api.operations.multimedia.addtoitem.AddMultimediaToItemOperation;
import com.onlineshop.store.api.operations.multimedia.addtoitem.AddMultimediaToItemResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddMultimediaToItemCore implements AddMultimediaToItemOperation {
    @Override
    public AddMultimediaToItemResult process(AddMultimediaToItemInput input) {
        return null;
    }
}
