package com.backend.swiftly.BOOKING.service;

import com.backend.swiftly.BOOKING.entity.Booking;
import com.backend.swiftly.BOOKING.repository.BookRepo;
import com.backend.swiftly.SLOTS.controller.SlotController;
import com.backend.swiftly.SLOTS.entity.Slots;
import com.backend.swiftly.SLOTS.repository.SlotsRepo;
import com.backend.swiftly.SLOTS.service.SlotService;
import com.backend.swiftly.VENDOR.entity.Vendor;
import com.backend.swiftly.VENDOR.repository.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class BookingService {

    @Autowired
    VendorRepo vendorRepo;
    @Autowired
    SlotsRepo slotsRepo;
    @Autowired
    SlotService slotService;
    @Autowired
    BookRepo bookRepo;
    public  Booking book(long vendorId, int startTime,String userEmail) {
       String flag= slotService.book(vendorId,startTime);
        Booking booked = new Booking();
       if(flag.equals("Success")){

           Vendor ven=vendorRepo.getById(vendorId);

           booked.setPrice(ven.getPrice());
           booked.setVendorName(ven.getvName());
           booked.setStartTime(startTime);
           booked.setEndTime(startTime+1);
           booked.setVendorId(vendorId);
           Slots s=slotsRepo.findByvendorIdAndstartTime(vendorId,startTime);
           booked.setSlotId(s.getId());
           booked.setUserId(userEmail);

           return bookRepo.save(booked);
       }
        else {
            return booked;
       }

    }
}
