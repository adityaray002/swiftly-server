package com.backend.swiftly.SLOTS.controller;

import com.backend.swiftly.SLOTS.service.SlotService;
import com.backend.swiftly.VENDOR.common.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/slots")
@CrossOrigin
public class SlotController {
    @Autowired
    SlotService slotService;
//    @PostMapping("/createSlots")
//    public String createSlots(){
//        return slotService.createAndSave();
//    }
    @PostMapping("/setSlots")
    public String setSlots(){
        return slotService.setslots();
    }

    @PostMapping("/book/{vendorId}/{startTime}")
    public String book(@PathVariable long vendorId,@PathVariable int startTime){
        return slotService.book(vendorId,startTime);
    }

    @GetMapping("/{vid}")
    @ResponseBody
    public APIResponse selectVendor(@PathVariable long vid){
        return slotService.selectvendor(vid);
    }




}
