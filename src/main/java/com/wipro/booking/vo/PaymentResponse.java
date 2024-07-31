package com.wipro.booking.vo;

public class PaymentResponse {
    private Long bookingId;
    private String status;

    public PaymentResponse(Long bookingId, String status) {
        this.bookingId = bookingId;
        this.status = status;
    }

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PaymentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PaymentResponse [bookingId=" + bookingId + ", status=" + status + "]";
	}

    
}
