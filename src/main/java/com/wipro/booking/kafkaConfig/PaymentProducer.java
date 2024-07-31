package com.wipro.booking.kafkaConfig;

import java.util.concurrent.CompletableFuture;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.wipro.booking.entity.Booking;
import com.wipro.booking.vo.PaymentMessage;

@Service
public class PaymentProducer {
    private final KafkaTemplate<String, PaymentMessage> kafkaTemplate;

    public PaymentProducer(KafkaTemplate<String, PaymentMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPaymentMessage(PaymentMessage message) {
        kafkaTemplate.send("T1", message);
    }
}