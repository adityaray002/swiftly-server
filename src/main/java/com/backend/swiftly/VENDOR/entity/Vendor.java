package com.backend.swiftly.VENDOR.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long vId;
    private String vName;
    private String email;

    private String password;

    private String mobileNo;

    private String address;

    private int startTime;
    private int endTime;
    private int price;

    private int total;
    private int available;

    public Vendor() {
    }

    public Vendor(long vId, String vName, String email, String password, String mobileNo, String address, int startTime, int endTime, int price,int total,int available) {
        this.vId = vId;
        this.vName = vName;
        this.email = email;
        this.password = password;
        this.mobileNo = mobileNo;
        this.address = address;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.total=total;
        this.available= available;
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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getPrice() {
        return price;
    }

    public long getvId() {
        return vId;
    }

    public void setvId(long vId) {
        this.vId = vId;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "vId=" + vId +
                ", vName='" + vName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", address='" + address + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", price=" + price +
                ", total=" + total +
                ", available=" + available +
                '}';
    }
}
