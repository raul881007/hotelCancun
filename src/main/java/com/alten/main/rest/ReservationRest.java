package com.alten.main.rest;

import com.alten.main.model.Reservation;
import com.alten.main.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/reservation/")
public class ReservationRest {

    @Autowired
    private ReservationService reservationService;


    @GetMapping
    private ResponseEntity<List<Reservation>> getReservations(){
        return ResponseEntity.ok(reservationService.findAll());
    }

    @PostMapping
    private ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation){

        try {
            Reservation nReservation= reservationService.save(reservation);
            return ResponseEntity.created(new URI("/reservation/"+ reservation.getId())).body(reservation);
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping(value = "{id}")
    private ResponseEntity<Boolean> deleteReservation(@PathVariable("id") Long id){
        reservationService.deleteById(id);
        return ResponseEntity.ok(reservationService.findById(id)==null);
    }

    @PutMapping(value="{id}")
    @ResponseStatus(HttpStatus.OK)
    private Reservation updateReservation(@RequestBody Reservation reservation,@PathVariable("id") Long id){
        return reservationService.findById(id)
                .map(reserv -> {
                    reserv.setClient(reservation.getClient());
                    reserv.setEndDate(reservation.getEndDate());
                    reserv.setInitialDate(reservation.getInitialDate());
                    reserv.setRoom(reservation.getRoom());
                    return reservationService.save(reserv);
                })
                .orElseGet(() -> {
                    reservation.setId(id);
                    return reservationService.save(reservation);
                });
    }

    @RequestMapping(value = "by_room/{idroom}", method = GET)
    @ResponseStatus(HttpStatus.OK)
    private  List<Reservation> getReservationsbyRoom(@PathVariable("idroom") Long idroom){

        return reservationService.getReservationsByRoom(idroom);
    }






}
