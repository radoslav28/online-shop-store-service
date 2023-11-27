package com.onlineshop.store.api.operations.multimedia.addtoitem;

import com.onlineshop.store.api.base.ProcessorResult;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class AddMultimediaToItemResult implements ProcessorResult {
    private final String message = "Successfully added";
}
