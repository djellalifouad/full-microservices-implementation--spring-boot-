package com.example.msreservation;

import com.example.msreservation.entity.Client;
import com.example.msreservation.entity.Reservation;
import com.example.msreservation.repository.ClientRepository;
import com.example.msreservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.sql.Date;
@SpringBootApplication
@EnableFeignClients
public class MsReservationApplication  implements CommandLineRunner {
@Autowired
    ReservationRepository reservationRepository;
@Autowired
    ClientRepository clientRepository;
    public static void main(String[] args) {
        SpringApplication.run(MsReservationApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        Client client = clientRepository.save(new Client(null,"djellali",null));
        Client client2 = clientRepository.save(new Client(null,"malki",null));
        Reservation reservation = reservationRepository.save(new Reservation(null, Date.valueOf("2022-02-02"),Date.valueOf("2022-02-02"),client,1L));
        Reservation reservation2 = reservationRepository.save(new Reservation(null, Date.valueOf("2022-02-02"),Date.valueOf("2022-02-02"),client2,2L));
    }
}
