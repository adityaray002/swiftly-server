package com.backend.swiftly.BOOKING.repository;

import com.backend.swiftly.BOOKING.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Booking,Long> {
}
