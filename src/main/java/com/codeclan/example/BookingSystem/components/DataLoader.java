package com.codeclan.example.BookingSystem.components;

import com.codeclan.example.BookingSystem.Repositiories.BookingRepository.BookingRepository;
import com.codeclan.example.BookingSystem.Repositiories.CourseRepository.CourseRepository;
import com.codeclan.example.BookingSystem.Repositiories.CustomerRepository.CustomerRepository;
import com.codeclan.example.BookingSystem.models.Booking;
import com.codeclan.example.BookingSystem.models.Course;
import com.codeclan.example.BookingSystem.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {

        Course course1 = new Course("Pilates", "Portobello", 4);
        courseRepository.save(course1);

        Customer customer1 = new Customer("Jim", "Portobello", 26);
        customerRepository.save(customer1);

        Booking booking1 = new Booking("01-01-2019", course1, customer1);
        bookingRepository.save(booking1);


        Course course2 = new Course("Meditation", "Edinburgh", 3);
        courseRepository.save(course2);

        Customer customer2 = new Customer("Jen", "Portobello", 31);
        customerRepository.save(customer2);

        Booking booking2 = new Booking("01-01-2019", course2, customer2);
        bookingRepository.save(booking2);


        Booking booking3 = new Booking("01-01-2019", course2, customer1);
        bookingRepository.save(booking3);

    }

}
