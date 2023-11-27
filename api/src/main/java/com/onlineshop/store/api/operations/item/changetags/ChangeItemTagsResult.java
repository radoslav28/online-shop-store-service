package com.onlineshop.store.api.operations.item.changetags;

import com.onlineshop.store.api.base.ProcessorResult;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ChangeItemTagsResult implements ProcessorResult {
    private final String message = "Successfully changed";
}
