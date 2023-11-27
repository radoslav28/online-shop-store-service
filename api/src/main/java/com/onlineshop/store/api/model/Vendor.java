package com.onlineshop.store.api.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vendor {
    @UUID
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String phone;
}
