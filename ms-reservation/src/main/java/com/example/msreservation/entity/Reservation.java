package com.example.msreservation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idReservation ;
    private Date dateDebut;
    private Date dateFin;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idClient")
    private Client client;
    private Long idChambre;

}
