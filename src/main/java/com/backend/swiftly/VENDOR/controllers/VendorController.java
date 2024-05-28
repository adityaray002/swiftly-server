package com.backend.swiftly.VENDOR.controllers;

import com.backend.swiftly.SLOTS.controller.SlotController;
import com.backend.swiftly.VENDOR.common.APIResponse;
import com.backend.swiftly.VENDOR.common.CustomVendor;
import com.backend.swiftly.VENDOR.entity.Vendor;
import com.backend.swiftly.VENDOR.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

@RestController
@RequestMapping("/vendor")
@CrossOrigin
public class VendorController {
    @Autowired
    private VendorService vendorService;
    @Autowired
    private SlotController slotController;

    @PostMapping("/register")
    public APIResponse register(@RequestBody Vendor vendor) {

        APIResponse saved = vendorService.saveVendor(vendor);
        slotController.setSlots();
        return saved;


    }

    @GetMapping("/getvendors")
    public APIResponse getAllVendors() {
        return vendorService.getAllVendors();
    }


    @GetMapping("/getvendor/{vId}")
    public Optional<Vendor> getVendorById(@PathVariable long vId) {
        return vendorService.getVendorById(vId);
    }


    @PostMapping("/signin")
    public String signin(@RequestBody CustomVendor customVendor) throws UserPrincipalNotFoundException {
        return vendorService.authenticateVendor(customVendor);
    }


}
