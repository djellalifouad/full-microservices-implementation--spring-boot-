package com.example.mshotel.repository;

import com.example.mshotel.entity.Chambre;
import com.example.mshotel.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {


}
