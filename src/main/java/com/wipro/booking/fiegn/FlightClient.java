package com.wipro.booking.fiegn;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.booking.vo.FlightVO;

@FeignClient(name = "flight-data-service", url = "http://localhost:8000")

public interface FlightClient {
    @GetMapping("/flights/search")
    List<FlightVO> searchFlights(@RequestParam String source, @RequestParam String destination, @RequestParam String travelDate);
}
