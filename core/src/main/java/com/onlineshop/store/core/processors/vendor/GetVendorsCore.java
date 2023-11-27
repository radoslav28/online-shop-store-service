package com.onlineshop.store.core.processors.vendor;

import com.onlineshop.store.api.exceptions.ServiceUnavailableException;
import com.onlineshop.store.api.model.VendorModel;
import com.onlineshop.store.api.operations.vendor.getall.GetVendorsInput;
import com.onlineshop.store.api.operations.vendor.getall.GetVendorsOperation;
import com.onlineshop.store.api.operations.vendor.getall.GetVendorsResult;
import com.onlineshop.store.persistence.entities.Vendor;
import com.onlineshop.store.persistence.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetVendorsCore implements GetVendorsOperation {

    private final VendorRepository vendorRepository;
    private final ConversionService conversionService;

    @Override
    public GetVendorsResult process(GetVendorsInput input) {

        try {

            return GetVendorsResult
                    .builder()
                    .vendorModels(vendorRepository
                            .findAll()
                            .stream()
                            .map(v -> conversionService.convert(v, VendorModel.class))
                            .toList())
                    .build();

        } catch (JDBCConnectionException e) {
            throw new ServiceUnavailableException();
        }
    }
}
