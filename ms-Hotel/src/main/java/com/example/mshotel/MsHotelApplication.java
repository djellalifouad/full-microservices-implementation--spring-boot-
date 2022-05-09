package com.example.mshotel;

import com.example.mshotel.entity.Chambre;
import com.example.mshotel.entity.Hotel;
import com.example.mshotel.repository.ChambreRepository;
import com.example.mshotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsHotelApplication implements CommandLineRunner {
    @Autowired
    ChambreRepository chambreRepository;
    @Autowired
    HotelRepository hotelRepository;

    public static void main(String[] args) {
        SpringApplication.run(MsHotelApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Hotel hotel = hotelRepository.save(new Hotel(null,"sheraton",null,0));
        Hotel hotel2 = hotelRepository.save(new Hotel(null,"ibis",null,0));
        Chambre chambre = chambreRepository.save(new Chambre(null,1,"type1",hotel,null));
        Chambre chambre2 = chambreRepository.save(new Chambre(null,2,"type2",hotel2,null));
    }
}
