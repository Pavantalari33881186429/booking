package com.wipro.booking.vo;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class FlightVO {

    private Long flightId;
    private String flightNumber;
    private String flightName;
    private String source;
    private String destination;
    private double price;
    private LocalDate travelDate;
    private String startTime;
    private String reachTime;
	public Long getFlightId() {
		return flightId;
	}
	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getReachTime() {
		return reachTime;
	}
	public void setReachTime(String reachTime) {
		this.reachTime = reachTime;
	}
	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", flightNumber=" + flightNumber + ", flightName=" + flightName
				+ ", source=" + source + ", destination=" + destination + ", price=" + price + ", travelDate="
				+ travelDate + ", startTime=" + startTime + ", reachTime=" + reachTime + "]";
	}
	public FlightVO(Long flightId, String flightNumber, String flightName, String source, String destination,
			double price, LocalDate travelDate, String startTime, String reachTime) {
		super();
		this.flightId = flightId;
		this.flightNumber = flightNumber;
		this.flightName = flightName;
		this.source = source;
		this.destination = destination;
		this.price = price;
		this.travelDate = travelDate;
		this.startTime = startTime;
		this.reachTime = reachTime;
	}
	public FlightVO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
