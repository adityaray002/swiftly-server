package com.backend.swiftly.VENDOR.repository;

import com.backend.swiftly.VENDOR.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepo extends JpaRepository<Vendor,Long> {

    Vendor findByEmail(String email);
}
