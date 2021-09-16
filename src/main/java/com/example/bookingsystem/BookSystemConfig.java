package com.example.bookingsystem;

import com.example.bookingsystem.movie.Movie;
import com.example.bookingsystem.movie.MovieRepository;
import com.example.bookingsystem.seat.Seat;
import com.example.bookingsystem.seat.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookSystemConfig implements CommandLineRunner {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public void run(String... args) throws Exception {
        Movie yourName = new Movie(1L, "Kimi No Nava", LocalTime.of(11, 30));
        Movie mugenTrain = new Movie(2L, "Demon Slayer: the mugen train", LocalTime.of(14, 30));
        movieRepository.saveAll(List.of(yourName, mugenTrain));

        List<Seat> seats= new ArrayList<>();
        for(char i = 'A'; i < 'J'; i++) {
            for (Integer j = 0; j < 10; j++) {
                String id = "";
                id = i + ":" + j.toString();
                Seat seat = new Seat(id, false);
                seats.add(seat);
            }
        }
        seatRepository.saveAll(seats);
    }
}
