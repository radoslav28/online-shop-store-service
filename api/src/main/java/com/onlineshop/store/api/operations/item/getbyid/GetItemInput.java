package com.onlineshop.store.api.operations.item.getbyid;

import com.onlineshop.store.api.base.ProcessorInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetItemInput implements ProcessorInput {

    @UUID
    @NotBlank
    private String itemId;
}
