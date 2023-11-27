package com.onlineshop.store.core.converters.vendor;

import com.onlineshop.store.api.model.VendorModel;
import com.onlineshop.store.persistence.entities.Vendor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class VendorToVendorModel implements Converter<Vendor, VendorModel> {
    @Override
    public VendorModel convert(Vendor source) {
        return VendorModel
                .builder()
                .id(String.valueOf(source.getId()))
                .name(source.getName())
                .phone(source.getPhone())
                .build();
    }
}
