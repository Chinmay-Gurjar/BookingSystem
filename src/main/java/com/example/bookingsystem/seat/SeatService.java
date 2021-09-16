package com.example.bookingsystem.seat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeatService {

    private final SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> getSeats() {
        return seatRepository.findAll();
    }

    public void bookSeat(List<String> ids) {
        List<Seat> seats = seatRepository.findAllById(ids);
        for (Seat seat : seats) {
            System.out.println(seat.getId());
            System.out.println(seat.getBooked());
            if (!seat.getBooked()) {
                seat.setBooked(true);
                System.out.println(seat.getBooked());
            }
        }
        System.out.println(seats);
        seatRepository.saveAll(seats);
    }
}