package com.wipro.booking.service;

import java.util.List;



import com.wipro.booking.entity.Booking;
import com.wipro.booking.vo.PaymentMessage;

public interface BookingService {
    Booking saveBooking(Booking booking);
    List<Booking> getAllBookings();
    Booking getBookingById(Long id);
    Booking updateBooking(Long id, Booking bookingDetails);
    void deleteBooking(Long id);
    void updateBookingStatus(Long id, String status);
    void paymentProcessing(PaymentMessage message);
}
