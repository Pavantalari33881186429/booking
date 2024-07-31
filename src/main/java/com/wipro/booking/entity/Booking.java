package com.wipro.booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private Long flightId;
    private Long userId;
    private String status;
	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	public Long getFlightId() {
		return flightId;
	}
	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Booking(Long bookingId, Long flightId, Long userId, String status) {
		super();
		this.bookingId = bookingId;
		this.flightId = flightId;
		this.userId = userId;
		this.status = status;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}
