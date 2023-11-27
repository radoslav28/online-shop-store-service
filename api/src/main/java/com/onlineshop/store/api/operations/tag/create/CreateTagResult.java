package com.onlineshop.store.api.operations.tag.create;

import com.onlineshop.store.api.base.ProcessorResult;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTagResult implements ProcessorResult {
    private String id;
}
