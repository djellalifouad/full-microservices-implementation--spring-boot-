package com.example.msreservation.entity;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;



@Projection(name = "tohotel", types = Reservation.class)
public interface ReservationProjection {
    @Value("#{target.dateDebut}")
    public String getDateDebut();

    @Value("#{target.client.nom}")
    public String getNomClient();

}
