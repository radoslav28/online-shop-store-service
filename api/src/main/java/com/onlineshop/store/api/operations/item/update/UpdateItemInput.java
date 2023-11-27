package com.onlineshop.store.api.operations.item.update;

import com.onlineshop.store.api.base.ProcessorInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateItemInput implements ProcessorInput {

    @UUID
    @NotBlank
    private String  itemId;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @UUID
    @NotBlank
    private String vendorId;

    private List<@UUID @NotBlank String> tagIds;
}
