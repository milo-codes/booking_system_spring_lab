package com.codeclan.example.BookingSystem.controllers;

import com.codeclan.example.BookingSystem.Repositiories.BookingRepository.BookingRepository;
import com.codeclan.example.BookingSystem.Repositiories.CourseRepository.CourseRepository;
import com.codeclan.example.BookingSystem.Repositiories.CustomerRepository.CustomerRepository;
import com.codeclan.example.BookingSystem.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/course/{courseId}")
    public List<Customer> getAllCustomersForCourse(@PathVariable Long courseId) {
        return customerRepository.getAllCustomersForCourse(courseId);
    }

}
