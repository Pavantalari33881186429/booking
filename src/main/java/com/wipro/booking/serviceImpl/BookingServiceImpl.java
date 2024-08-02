package com.wipro.booking.serviceImpl;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.wipro.booking.entity.Booking;
import com.wipro.booking.kafkaConfig.BookingConsumer;
import com.wipro.booking.kafkaConfig.PaymentProducer;
import com.wipro.booking.repository.BookingRepository;
import com.wipro.booking.service.BookingService;
import com.wipro.booking.vo.PaymentMessage;
import com.wipro.booking.vo.PaymentResponse;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    PaymentProducer producer;
    
    @Autowired
    PaymentMessage message;
    
  

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public Booking updateBooking(Long id, Booking bookingDetails) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking != null) {
            booking.setFlightId(bookingDetails.getFlightId());
            booking.setUserName(bookingDetails.getUserName());
            booking.setStatus(bookingDetails.getStatus());
            return bookingRepository.save(booking);
        }
        return null;
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public void updateBookingStatus(Long id, String status) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking != null) {
            booking.setStatus(status);
            bookingRepository.save(booking);
        }
    }
    
    @Override
    public void paymentProcessing(PaymentMessage message) {
    	
    	producer.sendPaymentMessage(message);
    	
    	
    	
		
    }
}
