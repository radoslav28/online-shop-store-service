package com.onlineshop.store.api.operations.item.get.bytag;

import com.onlineshop.store.api.base.ProcessorInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetItemsByTagInput implements ProcessorInput {

    @UUID
    @NotBlank
    private String tagId;
}
