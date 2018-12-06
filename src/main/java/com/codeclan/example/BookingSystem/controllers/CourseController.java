package com.codeclan.example.BookingSystem.controllers;

import com.codeclan.example.BookingSystem.Repositiories.BookingRepository.BookingRepository;
import com.codeclan.example.BookingSystem.Repositiories.CourseRepository.CourseRepository;
import com.codeclan.example.BookingSystem.Repositiories.CustomerRepository.CustomerRepository;
import com.codeclan.example.BookingSystem.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/rating/{rating}")
    public List<Course> getAllCoursesWithRating(@PathVariable int rating) {
        return courseRepository.getAllCoursesWithRating(rating);
    }

    @GetMapping(value = "/customer/{customerId}")
    public List<Course> getAllCoursesForCustomer(@PathVariable Long customerId) {
        return courseRepository.getAllCoursesForCustomer(customerId);
    }

}
