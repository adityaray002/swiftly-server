package com.backend.swiftly.VENDOR.service;

import com.backend.swiftly.USER.common.CustomUser;
import com.backend.swiftly.VENDOR.common.APIResponse;
import com.backend.swiftly.VENDOR.common.CustomVendor;
import com.backend.swiftly.VENDOR.entity.Vendor;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

@Service
public interface VendorService {
      public APIResponse saveVendor(Vendor vendor);
     public APIResponse getAllVendors();

//    public APIResponse Authentication(CustomVendor customVendor);

    public String authenticateVendor(CustomVendor customVendor) throws UserPrincipalNotFoundException;
    Optional<Vendor> getVendorById(long vId);
}
