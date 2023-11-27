package com.onlineshop.store.api.operations.item.create;

import com.onlineshop.store.api.base.ProcessorInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateItemInput implements ProcessorInput {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    private String vendorId;

    private List<String> tagsIds;
}
