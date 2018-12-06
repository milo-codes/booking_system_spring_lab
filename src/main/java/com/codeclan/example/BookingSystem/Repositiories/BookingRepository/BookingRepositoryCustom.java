package com.codeclan.example.BookingSystem.Repositiories.BookingRepository;

import com.codeclan.example.BookingSystem.models.Booking;

import java.util.List;

public interface BookingRepositoryCustom {

    List<Booking> getAllBookingsForDate(String date);

}
