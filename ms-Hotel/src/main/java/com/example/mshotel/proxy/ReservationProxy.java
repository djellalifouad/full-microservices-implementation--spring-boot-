package com.example.mshotel.proxy;

import com.example.mshotel.models.Reservation;
import com.example.mshotel.repository.HotelRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="ms-reservation")
@LoadBalancerClient(name="ms-reservation")
public interface ReservationProxy {

    @GetMapping("/reservations/search/findReservationByIdChambre")
    CollectionModel<Reservation> getReseervations(@RequestParam("id") Long id, @RequestParam("projection") String p);
    @GetMapping("/reservations/search/countReservationByIdChambre")
    @CircuitBreaker(name="fall1", fallbackMethod = "fallbackCount")
    int getReseervationCount(@RequestParam("id") Long id);
    default int fallbackCount(Throwable throwable) {
        return 0;
    }
}
