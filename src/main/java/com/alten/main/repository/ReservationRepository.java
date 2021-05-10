package com.alten.main.repository;

import com.alten.main.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    public List<Reservation> getReservationsByRoom(Long roomId);

}
