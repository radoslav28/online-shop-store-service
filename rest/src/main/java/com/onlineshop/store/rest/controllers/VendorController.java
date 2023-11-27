package com.onlineshop.store.rest.controllers;

import com.onlineshop.store.api.operations.vendor.create.CreateVendorInput;
import com.onlineshop.store.api.operations.vendor.create.CreateVendorOperation;
import com.onlineshop.store.api.operations.vendor.create.CreateVendorResult;
import com.onlineshop.store.api.operations.vendor.getall.GetVendorsInput;
import com.onlineshop.store.api.operations.vendor.getall.GetVendorsOperation;
import com.onlineshop.store.api.operations.vendor.getall.GetVendorsResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendors")
@Tag(name = "Vendors Controller")
@RequiredArgsConstructor
@Validated
public class VendorController {

    private final CreateVendorOperation createVendor;
    private final GetVendorsOperation getVendors;

    @PostMapping
    @Operation(summary = "Create vendor", description = "Create vendor and return its id")
    public ResponseEntity<CreateVendorResult> addVendor (@RequestBody @Valid CreateVendorInput input) {

        return new ResponseEntity<>(createVendor.process(input), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all vendors", description = "Get all vendors")
    public ResponseEntity<GetVendorsResult> getVendors () {

        return new ResponseEntity<>(getVendors.process(new GetVendorsInput()), HttpStatus.OK);
    }
}
