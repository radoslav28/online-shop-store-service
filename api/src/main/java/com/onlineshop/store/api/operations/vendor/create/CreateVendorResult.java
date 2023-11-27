package com.onlineshop.store.api.operations.vendor.create;

import com.onlineshop.store.api.base.ProcessorResult;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateVendorResult implements ProcessorResult {
    private String id;
}
