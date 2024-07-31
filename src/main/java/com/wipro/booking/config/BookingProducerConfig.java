package com.wipro.booking.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import java.util.HashMap;
import java.util.Map;


import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class BookingProducerConfig {
	 @Bean
	    public <K, V> ProducerFactory<K, V> createVehicProducerFactory(){
		 
	        Map<String,Object> config = new HashMap<>();
	        config.put(org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	        config.put(org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	        config.put(org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
	        //config.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
	        return new DefaultKafkaProducerFactory<K, V>(config);
	    }

	    @Bean
	    public <K, V> KafkaTemplate<K, V> createNewsKafkaTemplate(){
	        return new KafkaTemplate<>(createVehicProducerFactory());
	    }
}
