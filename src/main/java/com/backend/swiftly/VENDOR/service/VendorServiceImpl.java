//package com.backend.swiftly.VENDOR.service;
//
//import com.backend.swiftly.VENDOR.common.APIResponse;
//import com.backend.swiftly.VENDOR.repository.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//public class VendorServiceImpl {
//}
package com.backend.swiftly.VENDOR.service;

import com.backend.swiftly.USER.common.CustomUser;
import com.backend.swiftly.USER.entity.User;
import com.backend.swiftly.USER.exceptions.UserNotFoundException;
import com.backend.swiftly.VENDOR.common.APIResponse;
import com.backend.swiftly.VENDOR.common.CustomVendor;
import com.backend.swiftly.VENDOR.entity.Vendor;
import com.backend.swiftly.VENDOR.exceptions.VendorNotFoundException;
import com.backend.swiftly.VENDOR.repository.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorServiceImpl implements VendorService {


    @Autowired
    private VendorRepo repo;

//    @Override
//    public APIResponse saveVendor(Vendor vendor) {
//
//        Vendor result=repo.save(vendor);
//        System.out.println(result);
//        APIResponse response = new APIResponse(200,result,null);
//        response.setStatus(200);
//        response.setData(vendor);
//        response.setError(null);
//        return response;
//
//
//
//    }

    @Override
    public APIResponse getAllVendors() {

        List<Vendor> vendors =  repo.findAll();
        APIResponse response = new APIResponse(200,vendors,null);
        return response;
    }
    @Override
    public Optional<Vendor> getVendorById(long vId){
        return repo.findById(vId);
    }

@Override
public com.backend.swiftly.VENDOR.common.APIResponse saveVendor(Vendor vendor) {
    if(repo.findByEmail(vendor.getEmail())==null){
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String encryptedPwd=bcrypt.encode(vendor.getPassword());
        vendor.setPassword(encryptedPwd);
        int check = ResponseEntity.status(HttpStatus.CREATED).build().getStatusCode().value();
        System.out.println(check);
        Vendor result=repo.save(vendor);
        com.backend.swiftly.VENDOR.common.APIResponse response = new com.backend.swiftly.VENDOR.common.APIResponse(check,result,false);
        response.setStatus(check);
        response.setData(vendor);
        response.setIsError(false);
        System.out.println(response.getData());
        return response;
    }else if(repo.findByEmail(vendor.getEmail())!=null){
//        boolean vendorExists = true;
        com.backend.swiftly.VENDOR.common.APIResponse response = new com.backend.swiftly.VENDOR.common.APIResponse(200, null,false);
        response.setStatus(200);
        response.setData("message:Vendor already exists");
        response.setIsError(false);
        System.out.println(response.getData());
        return response;
    }

    return new com.backend.swiftly.VENDOR.common.APIResponse(200,null,true);

}
    public String authenticateVendor(CustomVendor customVendor) throws UserNotFoundException {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        Optional<Vendor> opVendor = Optional.ofNullable(repo.findByEmail(customVendor.getEmail()));

        if(opVendor.isPresent()){
            Vendor dbVendor=opVendor.get();
            if(bcrypt.matches(customVendor.getPassword(), dbVendor.getPassword()))
                return "Authenticated Vendor";
            else
                return "Incorrect Password";
        }throw new VendorNotFoundException("No vendor is not found for this email!!!");
    }

}
