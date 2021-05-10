package com.alten.main.model;


import javax.persistence.*;

@Entity
@Table(name="room")
public class Room {


    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private int number;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    /**
     * Empty constructor
     */
    public Room() {
    }

    /**
     * Creates a new constructor
     * @param number creates room with one number
     */
    public Room(int number, String description, String imageUrl) {
        this.number = number;
        this.description = description;
        this.imageUrl = imageUrl;
    }
    /**
     * Gets the imageUrl of the room
     * @return imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }
    /**
     * Changes the number
     * @param imageUrl
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
