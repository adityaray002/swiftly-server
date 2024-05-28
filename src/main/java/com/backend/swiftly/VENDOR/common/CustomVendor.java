package com.backend.swiftly.VENDOR.common;




public class CustomVendor {
    private String email;
    private String password;

    public CustomVendor(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "CustomUser{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
