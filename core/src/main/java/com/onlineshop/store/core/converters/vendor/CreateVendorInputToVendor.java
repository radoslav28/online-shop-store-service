package com.onlineshop.store.core.converters.vendor;

import com.onlineshop.store.api.operations.vendor.create.CreateVendorInput;
import com.onlineshop.store.persistence.entities.Vendor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CreateVendorInputToVendor implements Converter<CreateVendorInput, Vendor> {

    @Override
    public Vendor convert(CreateVendorInput source) {
        return Vendor
                .builder()
                .name(source.getName())
                .phone(source.getPhone())
                .build();
    }
}
