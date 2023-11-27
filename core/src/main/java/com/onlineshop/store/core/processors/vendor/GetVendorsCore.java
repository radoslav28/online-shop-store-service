package com.onlineshop.store.core.processors.vendor;

import com.onlineshop.store.api.operations.vendor.getall.GetVendorsInput;
import com.onlineshop.store.api.operations.vendor.getall.GetVendorsOperation;
import com.onlineshop.store.api.operations.vendor.getall.GetVendorsResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetVendorsCore implements GetVendorsOperation {
    @Override
    public GetVendorsResult process(GetVendorsInput input) {
        return null;
    }
}
