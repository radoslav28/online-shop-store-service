package com.onlineshop.store.api.operations.item.changetags;

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
public class ChangeItemTagsInput implements ProcessorInput {

    @UUID
    @NotBlank
    private String itemId;

    private List<@UUID @NotBlank String> tagIds;
}
