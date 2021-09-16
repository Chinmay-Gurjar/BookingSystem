package com.example.bookingsystem.movie;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalTime;

@Entity
@Table
public class Movie {
    @Id
    private Long id;
    private String name;
    private LocalTime timeSlots;

    public Movie() {
    }

    public Movie(Long id, String name, LocalTime timeSlots) {
        this.id = id;
        this.name = name;
        this.timeSlots = timeSlots;
    }

    public Movie(String name, LocalTime timeSlots) {
        this.name = name;
        this.timeSlots = timeSlots;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(LocalTime timeSlots) {
        this.timeSlots = timeSlots;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", timeSlots=" + timeSlots +
                '}';
    }
}
