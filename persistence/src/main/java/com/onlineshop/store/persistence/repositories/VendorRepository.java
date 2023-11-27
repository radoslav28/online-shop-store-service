package com.onlineshop.store.persistence.repositories;

import com.onlineshop.store.persistence.entities.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface VendorRepository extends JpaRepository<Vendor, UUID> {
}
