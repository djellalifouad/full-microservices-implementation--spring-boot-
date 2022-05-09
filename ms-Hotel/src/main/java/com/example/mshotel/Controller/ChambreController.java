package com.example.mshotel.Controller;

import com.example.mshotel.entity.Chambre;
import com.example.mshotel.entity.Hotel;
import com.example.mshotel.proxy.ReservationProxy;
import com.example.mshotel.repository.ChambreRepository;
import com.example.mshotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api")
public class ChambreController {
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    ReservationProxy reservationProxy;
    @Autowired
    ChambreRepository chambreRepository ;
    @GetMapping("/chambres")
    List<Chambre> getChambreAvecReservation() {
        System.out.println("we are here");
        List<Chambre> chambres = chambreRepository.findAll();

        chambres.forEach(chambre -> {
            chambre.setReservations(
                    new ArrayList<>(reservationProxy.getReseervations(chambre.getIdChambre(),"tohotel").getContent()));
        });
        return chambres;
    }
    @GetMapping("/hotel/reservation")
    List<Hotel> getHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        hotels.forEach(hotel -> {
            AtomicInteger reservationCount = new AtomicInteger();
            hotel.getChambres().forEach(chambre -> {
                reservationCount.addAndGet(reservationProxy.getReseervationCount(chambre.getIdChambre()));
            });
            hotel.setNbrReservation(reservationCount.get());
        });
        return  hotels;
    };


}
