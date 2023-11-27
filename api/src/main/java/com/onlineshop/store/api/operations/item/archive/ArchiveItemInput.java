package com.onlineshop.store.api.operations.item.archive;

import com.onlineshop.store.api.base.ProcessorInput;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArchiveItemInput implements ProcessorInput {

    @UUID
    private String itemId;
}
