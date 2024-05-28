package com.backend.swiftly.SLOTS.repository;

import com.backend.swiftly.SLOTS.entity.Slots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlotsRepo extends JpaRepository<Slots,Long> {

    List<Slots> findByvendorId(long id);



    @Query(value = "select * from Slots where Slots.vendorId=?1",nativeQuery = true)
    Slots findByVendorId(Long vid);


    @Query(value = "select * from slots where slots.vendor_id=?1 AND start_time=?2",nativeQuery = true)
    Slots findByvendorIdAndstartTime(Long vendorId, Integer startTime);





}
