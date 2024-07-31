package com.wipro.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.booking.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}

