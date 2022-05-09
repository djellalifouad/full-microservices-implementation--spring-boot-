package com.example.msreservation.repository;

import com.example.msreservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findReservationByIdChambre(Long id);
    int countReservationByIdChambre(Long id);
}
