package com.onlineshop.store.api.operations.item.get.byid;

import com.onlineshop.store.api.base.ProcessorInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetItemByIdInput implements ProcessorInput {

    @UUID
    @NotBlank
    private String itemId;
}
