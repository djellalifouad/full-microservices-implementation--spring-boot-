package com.example.mshotel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue
    private Long idHotel ;
    private String nom ;
    @JsonIgnore
    @OneToMany(mappedBy = "hotel")
    Collection<Chambre> chambres;
    @Transient
    private int nbrReservation;
}
