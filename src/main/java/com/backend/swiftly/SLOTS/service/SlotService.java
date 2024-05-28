package com.backend.swiftly.SLOTS.service;

import com.backend.swiftly.SLOTS.entity.Slots;
import com.backend.swiftly.SLOTS.repository.SlotsRepo;
import com.backend.swiftly.VENDOR.common.APIResponse;
import com.backend.swiftly.VENDOR.entity.Vendor;
import com.backend.swiftly.VENDOR.repository.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SlotService {
    @Autowired
    VendorRepo vendorRepo;

    @Autowired
    SlotsRepo slotsRepo;

//    public String createAndSave(){
//        List<Vendor>vendor=vendorRepo.findAll();
//        ArrayList<Slots> slots = new ArrayList<>();
//
//        for (Vendor value : vendor) {
//            Slots slot = new Slots();
//            Vendor ven = value;
//
//            slot.setVendorId(ven.getvId());
//            int available = (int) (ven.getTotal()-ven.getTotal() * 0.05);
//            slot.setAvailable(available);
//            slot.setStartTime(ven.getStartTime());
//            slot.setEndTime(ven.getEndTime());
//
//            slotsRepo.save(slot);
//           // System.out.println(slot.getId()+" "+slot.getVendorId()+" "+slot.getAvailable()+" "+slot.getStartTime()+" "+slot.getEndTime());
//
//
//        }
//
//
//        return "vendor";
//    }

    public APIResponse selectvendor(long vid) {
        List<Slots> slots=  slotsRepo.findByvendorId(vid);
        ArrayList<Slots> specificVendorSlot = new ArrayList<>();
        System.out.println(slots);
        APIResponse response = new APIResponse(200,slots,null);

        return response;
    }


    public boolean isExistByVendorId(long id) {
        List<Slots> member = slotsRepo.findByvendorId(id);
        return !member.isEmpty();
    }
    public String setslots(){
        List<Vendor>vendor=vendorRepo.findAll();
        ArrayList<Slots> slots = new ArrayList<>();

        for (Vendor value : vendor) {

            Vendor ven = value;
            boolean exists =isExistByVendorId(ven.getvId());
            if(exists){

            }else{
                for(int i=ven.getStartTime();i<ven.getEndTime();i++){

                    Slots slot = new Slots();
                    slot.setVendorId(ven.getvId());
                    int available = (int) (ven.getTotal()-ven.getTotal() * 0.05);
                    slot.setAvailable(available);
                    slot.setStartTime(i);
                    slot.setEndTime(i+1);
                    slot.setVendorId(ven.getvId());
                    slotsRepo.save(slot);

                }
            }

        }


        return "vendor";
    }

    public String book(long vendorId, int startTime) {
        Slots slot = slotsRepo.findByvendorIdAndstartTime(vendorId, startTime);
        int available = slot.getAvailable()-1;
        if(available==-1){
            return "Failed";
        }
        if(available>=0){
            slot.setAvailable(slot.getAvailable()-1);
            slotsRepo.save(slot);
            return "Success";
        }
            return "Failed";



    }
}
