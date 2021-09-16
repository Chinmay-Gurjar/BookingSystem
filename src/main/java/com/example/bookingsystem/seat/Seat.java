package com.example.bookingsystem.seat;

import jdk.jfr.Enabled;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Seat {
    @Id
    private String id;
    private Boolean booked;

    public Seat() {
    }

    public Seat(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Seat(String id, Boolean booked) {
        this.id = id;
        this.booked = booked;
    }

    public Boolean getBooked() {
        return booked;
    }

    public void setBooked(Boolean booked) {
        this.booked = booked;
    }
}