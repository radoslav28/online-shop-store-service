package com.onlineshop.store.api.operations.item.archive;

import com.onlineshop.store.api.base.ProcessorResult;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ArchiveItemResult implements ProcessorResult {
    private final String message = "Successfully archived";
}
