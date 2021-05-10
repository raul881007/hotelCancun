package com.alten.main.model;


import javax.persistence.*;

@Entity
@Table(name="room")
public class Room {

    /**
     * Table id
     */
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Column with the room number
     */
    @Column(name = "number")
    private int number;

    /**
     * Column with the room description
     */
    @Column(name = "description")
    private String description;


    /**
     * Empty constructor
     */
    public Room() {
    }

    /**
     * Creates a new constructor
     * @param number creates room with one number
     */
    public Room(int number, String description) {
        this.number = number;
        this.description = description;
    }

    /**
     * Gets the identification in the room
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Gets the room number at the hotel
     * @return number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Changes the number
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Gets the room description at the hotel
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Changes the description of the room
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
