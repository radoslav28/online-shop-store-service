package com.onlineshop.store.core.processors.multimedia;

import com.onlineshop.store.api.operations.multimedia.getbyitem.GetMultimediaByItemInput;
import com.onlineshop.store.api.operations.multimedia.getbyitem.GetMultimediaByItemOperation;
import com.onlineshop.store.api.operations.multimedia.getbyitem.GetMultimediaByItemResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetMultimediaByItemCore implements GetMultimediaByItemOperation {
    @Override
    public GetMultimediaByItemResult process(GetMultimediaByItemInput input) {
        return null;
    }
}
