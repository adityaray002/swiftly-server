package com.backend.swiftly.BOOKING.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long BookingId;
    private  String vendorName;
    private long slotId;
    private String userId;
    private int startTime;
    private long vendorId;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Booking() {
    }

    public long getVendorId() {
        return vendorId;
    }

    public void setVendorId(long vendorId) {
        this.vendorId = vendorId;
    }

    public long getBookingId() {
        return BookingId;
    }

    public void setBookingId(long bookingId) {
        BookingId = bookingId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public long getSlotId() {
        return slotId;
    }

    public void setSlotId(long slotId) {
        this.slotId = slotId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Booking(long bookingId, String vendorName, long slotId, String userId, int startTime, int endTime, Date timeStamp,int price, long vendorId) {
        this.BookingId = bookingId;
        this.vendorName = vendorName;
        this.slotId = slotId;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.timeStamp = timeStamp;
        this.price = price;
        this.vendorId = vendorId;
    }

    private int endTime;
    @CreationTimestamp
    private Date timeStamp;





}
