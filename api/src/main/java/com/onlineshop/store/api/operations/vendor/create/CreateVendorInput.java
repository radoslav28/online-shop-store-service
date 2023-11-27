package com.onlineshop.store.api.operations.vendor.create;

import com.onlineshop.store.api.base.ProcessorInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateVendorInput implements ProcessorInput {

    @NotBlank
    private String name;

    @NotBlank
    private String phone;
}
