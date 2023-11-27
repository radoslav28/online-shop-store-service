package com.onlineshop.store.api.operations.multimedia.getbyitem;

import com.onlineshop.store.api.base.ProcessorResult;
import com.onlineshop.store.api.model.Multimedia;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetMultimediaByItemResult implements ProcessorResult {
    List<Multimedia> multimedia;
}
