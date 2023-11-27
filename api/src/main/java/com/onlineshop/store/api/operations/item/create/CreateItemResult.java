package com.onlineshop.store.api.operations.item.create;

import com.onlineshop.store.api.base.ProcessorResult;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateItemResult implements ProcessorResult {
    private String id;
}
