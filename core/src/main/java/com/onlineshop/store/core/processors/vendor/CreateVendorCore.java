package com.onlineshop.store.core.processors.vendor;

import com.onlineshop.store.api.exceptions.ServiceUnavailableException;
import com.onlineshop.store.api.operations.vendor.create.CreateVendorInput;
import com.onlineshop.store.api.operations.vendor.create.CreateVendorOperation;
import com.onlineshop.store.api.operations.vendor.create.CreateVendorResult;
import com.onlineshop.store.persistence.entities.Vendor;
import com.onlineshop.store.persistence.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateVendorCore implements CreateVendorOperation {

    private final VendorRepository vendorRepository;
    private  final ConversionService conversionService;

    @Override
    public CreateVendorResult process(CreateVendorInput input) {

        try {

            Vendor vendor = conversionService.convert(input, Vendor.class);
            Vendor persisted = vendorRepository.save(vendor);

            return CreateVendorResult
                    .builder()
                    .id(String.valueOf(persisted.getId()))
                    .build();

        } catch (JDBCConnectionException e) {
            throw new ServiceUnavailableException();
        }
    }
}
