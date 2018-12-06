package com.codeclan.example.BookingSystem.Repositiories.CustomerRepository;

import com.codeclan.example.BookingSystem.models.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {

    List<Customer> getAllCustomersForCourse(Long courseId);

}
