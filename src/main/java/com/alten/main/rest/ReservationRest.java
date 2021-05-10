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

    /**
     * Connection to the service that provides the reservation data
     */
    @Autowired
    private ReservationService reservationService;

    /**
     * Get method that gets all reservations
     * @return ResponseEntity.ok() with a list of reservations
     */
    @GetMapping
    private ResponseEntity<List<Reservation>> getReservations(){
        return ResponseEntity.ok(reservationService.findAll());
    }

    /**
     * Method that creates a reservation with the data sent by the user
     * @param reservation
     * @return ResponseEntity.created() with a new reservation data or BadRequest if something is worng
     */
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

    /**
     * Method to delete a reservation given by the user
     * @param id Reservation id to delete it
     * @return ResponseEntity.ok() with boolean parameter saying if the reservation has been deleted.
     */
    @DeleteMapping(value = "{id}")
    private ResponseEntity<Boolean> deleteReservation(@PathVariable("id") Long id){
        reservationService.deleteById(id);
        return ResponseEntity.ok(reservationService.findById(id)==null);
    }


    /**
     * Method that updates the reservation data
     * @param reservation New reservation data
     * @param id reservation id
     * @return New reservation data
     */
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

    /**
     * Method that selects all existing reservations in a room
     * @param idroom room id
     * @return List with the reservations that exist in a room
     */
    @RequestMapping(value = "by_room/{idroom}", method = GET)
    @ResponseStatus(HttpStatus.OK)
    private  List<Reservation> getReservationsbyRoom(@PathVariable("idroom") Long idroom){

        return reservationService.getReservationsByRoom(idroom);
    }






}
