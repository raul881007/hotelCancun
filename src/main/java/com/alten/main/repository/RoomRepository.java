package com.alten.main.repository;

import com.alten.main.model.Reservation;
import com.alten.main.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {

}
