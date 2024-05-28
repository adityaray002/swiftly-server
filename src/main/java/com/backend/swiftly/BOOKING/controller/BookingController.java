package com.backend.swiftly.BOOKING.controller;

import com.backend.swiftly.BOOKING.entity.Booking;
import com.backend.swiftly.BOOKING.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookingController {
    @Autowired
    BookingService bookingService;

    @PostMapping("/slots/{userEmail}")
    public String book(@RequestBody Booking slots[], @PathVariable String userEmail){
        for(int i=0;i<slots.length;i++){
             bookingService.book(slots[i].getVendorId(),slots[i].getStartTime(),userEmail);
        }
    return "success";

    }

}
