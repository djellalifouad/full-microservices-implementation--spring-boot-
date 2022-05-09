package com.example.msreservation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @GeneratedValue
    @Id
    private Long idClient  ;
    private String nom;
    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private Collection<Reservation> reservations;

}
