package com.example.bookingsystem.seat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeatController {

    private final SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/getSeats")
    public List<Seat> getSeatAvailability(){
        return seatService.getSeats();
    }

    @PostMapping("/bookSeats")
    public void bookSeats(@RequestBody List<String> ids){
        seatService.bookSeat(ids);
    }
}