package com.wipro.booking.controller;

import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.booking.entity.Booking;
import com.wipro.booking.fiegn.FlightClient;
import com.wipro.booking.service.BookingService;
import com.wipro.booking.vo.FlightVO;
import com.wipro.booking.vo.PaymentMessage;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
@RequestMapping("/booking")
@CrossOrigin(origins = "*")
public class BookingController {
	
	private static final Logger log = LogManager.getLogger(BookingController.class);
    @Autowired
    private BookingService bookingService;

    @Autowired
    private FlightClient flightClient;
    
    
   

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }
    
    @CircuitBreaker(name = "searchFlights", fallbackMethod = "fallbackSearchFlights")
    @GetMapping("/search")
    public List<FlightVO> searchFlights(@RequestParam String source, @RequestParam String destination, @RequestParam String travelDate) {
        return flightClient.searchFlights(source, destination, travelDate);
    }

    @GetMapping("/search/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @PutMapping("/status/{id}")
    public void updateBookingStatus(@PathVariable Long id, @RequestParam String status) {
        bookingService.updateBookingStatus(id, status);
    }

    @PutMapping("/update/{id}")
    public Booking updateBooking(@PathVariable Long id, @RequestBody Booking bookingDetails) {
        return bookingService.updateBooking(id, bookingDetails);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }
  
    
    @PostMapping("/payment")
    public void paymentProcessing(@RequestBody PaymentMessage message) {
    	
    	try {
    		bookingService.paymentProcessing(message);
    	}catch(Exception e) {
    		bookingService.updateBookingStatus(message.getBookingId(), "failed");
    	}
    	
    	
    }
    
    public List<FlightVO> fallbackSearchFlights(String source, String destination, String travelDate, Throwable throwable) {
        
		// Log the error and return a default response
        log.error("Flight search failed: ", throwable);
        return Collections.emptyList(); // Or provide a default response
    }
}
