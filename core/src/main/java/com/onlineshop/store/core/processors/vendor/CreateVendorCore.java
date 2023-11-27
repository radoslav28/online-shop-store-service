package com.onlineshop.store.core.processors.vendor;

import com.onlineshop.store.api.operations.vendor.create.CreateVendorInput;
import com.onlineshop.store.api.operations.vendor.create.CreateVendorOperation;
import com.onlineshop.store.api.operations.vendor.create.CreateVendorResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateVendorCore implements CreateVendorOperation {
    @Override
    public CreateVendorResult process(CreateVendorInput input) {
        return null;
    }
}
