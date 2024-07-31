package com.wipro.booking.vo;

import org.springframework.stereotype.Component;

@Component
public class PaymentMessage {
	private Long bookingId;
	private double amount;
	private String modeOfPayment;
	private String status;
	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public PaymentMessage(Long bookingId, double amount, String modeOfPayment, String status) {
		super();
		this.bookingId = bookingId;
		this.amount = amount;
		this.modeOfPayment = modeOfPayment;
		this.status = status;
	}
	public PaymentMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
