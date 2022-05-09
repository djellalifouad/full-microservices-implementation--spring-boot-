package com.example.mshotel.entity;

import com.example.mshotel.models.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;
    private int numero;
    private String type;
    @ManyToOne
    @JoinColumn(name = "idHotel")
    private Hotel hotel;
    @Transient
    List<Reservation> reservations;
}
