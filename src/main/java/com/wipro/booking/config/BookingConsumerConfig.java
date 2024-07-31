package com.wipro.booking.config;

import java.util.*;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;



import com.wipro.booking.vo.PaymentResponse;


@EnableKafka
@Configuration
public class BookingConsumerConfig {

	@Bean
    public ConsumerFactory<String, PaymentResponse> consumerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "booking-group");
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        configProps.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        configProps.put(JsonDeserializer.USE_TYPE_INFO_HEADERS,"false");
        return new DefaultKafkaConsumerFactory<>(configProps);
    }

	    @Bean
	    public ConcurrentKafkaListenerContainerFactory<String, PaymentResponse> kafkaListenerContainerFactory() {
	        ConcurrentKafkaListenerContainerFactory<String, PaymentResponse> factory = new ConcurrentKafkaListenerContainerFactory<>();
	        factory.setConsumerFactory(consumerFactory());
	        return factory;
	    }
}
