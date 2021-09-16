package com.example.bookingsystem.seat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SeatController {

    private final SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/getSeats")
    public List<Seat> getSeatAvailability(){
        return seatService.getSeats();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/bookSeats")
    public void bookSeats(@RequestBody List<String> ids){
        seatService.bookSeat(ids);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @Cacheable(value = "seats")
    @GetMapping("/seats/{id}")
    public boolean seatAvailability(@PathVariable("id") String id) {
        return seatService.checkSeatAvailablilty(id);
    }
}