package com.backend.swiftly.VENDOR.exceptions;

public class VendorNotFoundException extends RuntimeException{
    public VendorNotFoundException(String message){
        super(message);
    }
}
