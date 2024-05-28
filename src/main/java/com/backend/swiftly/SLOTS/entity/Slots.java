package com.backend.swiftly.SLOTS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.boot.autoconfigure.web.WebProperties;
@Entity
@Getter
public class Slots {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Long vendorId;
    int Available;

    public Slots() {
    }

    int startTime;
    int endTime;

    public Slots(Long id, Long vendorId, int available, int startTime, int endTime) {
        this.id = id;
        this.vendorId = vendorId;
        Available = available;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public void setAvailable(int available) {
        Available = available;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
