package com.example.bookingsystem.seat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
            if (!seat.getBooked()) {
                seat.setBooked(true);
            }
        }
        seatRepository.saveAll(seats);
    }

    public boolean checkSeatAvailablilty(String id) {
        System.out.println("HEHHEHE");
        Optional<Seat> seat = seatRepository.findById(id);
        return seat.get().getBooked();
    }
}