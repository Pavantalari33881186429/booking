package com.wipro.booking.kafkaConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import com.wipro.booking.entity.Booking;
import com.wipro.booking.service.BookingService;
import com.wipro.booking.vo.PaymentResponse;




public class BookingConsumer {

private final KafkaTemplate<String, PaymentResponse> kafkaTemplate;

@Autowired
BookingService booksvc;
	
public BookingConsumer(KafkaTemplate<String, PaymentResponse> kafkaTemplate) {
	super();
	this.kafkaTemplate = kafkaTemplate;
     }



@KafkaListener(topics = "T2", groupId = "booking-group", containerFactory = "kafkaListenerContainerFactory",properties = {"spring.json.value.default.type=com.wipro.booking.vo.PaymentResponse"})
public String listen(PaymentResponse message) {
	     
	booksvc.updateBookingStatus(message.getBookingId(),message.getStatus());
	System.out.println(message.getStatus());
	return message.getStatus();
	        
	     }
}
