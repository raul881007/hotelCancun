package com.alten.main.rest;

import com.alten.main.model.Room;
import com.alten.main.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/room/")
public class RoomRest {

    @Autowired
    private RoomService roomService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<Room> getReservations(){
        return roomService.findAll();
    }



}
