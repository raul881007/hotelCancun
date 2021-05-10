package com.alten.main.model;

import javax.persistence.*;

/**
 * Entity for the access to reservation data
 *
 * @author Raul
 *
 */

@Entity
@Table(name="reservation")
public class Reservation {

    /**
     * Primary key
     */
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Relation with the client that facilitates access to their data
     */

    @Column(name="client")
    private String client;

    /**
     * Relation with the client that facilitates access to their data
     */
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    /**
     * Initial date of the reservation
     */
    @Column(name="initial_date")
    private String initialDate;

    /**
     * End date of the reservation
     */
    @Column(name="end_date")
    private String endDate;



    /**
     * Empty Constructor
     */
    public Reservation() {
    }

    /**
     * Constructor of the class with parameters
     * @param client with the client data
     * @param room with the room data
     * @param initialDate with the initial date of the reservation
     * @param endDate with the end date of the reservation
     */

    public Reservation(String client, Room room, String initialDate, String endDate) {
        this.client = client;
        this.room = room;
        this.initialDate = initialDate;
        this.endDate = endDate;
    }

    /**
     * Gets the name of the client
     * @return the Client
     */
    public String getClient() {
        return client;
    }

    /**
     * Gets the identification in the reservation
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Changes the id of the Reservation
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Method to get the current client
     * @param client
     */
    public void setClient(String client) {
        this.client = client;
    }

    /**
     * Method to get the current room of the reservation
     * @return room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Method to set the room of the reservation
     * @param room
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Gets the initial date of the reservation
     * @return initialDate
     */
    public String getInitialDate() {
        return initialDate;
    }

    /**
     *
     * @param initialDate changes the endDate of the reservation
     */
    public void setInitialDate(String initialDate) {
        this.initialDate = initialDate;
    }
    /**
     * Gets the end date of the reservation
     * @return endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Set end date in a reservation
     * @param endDate changes the endDate of the reservation
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
