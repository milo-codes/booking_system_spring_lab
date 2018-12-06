package com.codeclan.example.BookingSystem;

import com.codeclan.example.BookingSystem.Repositiories.BookingRepository.BookingRepository;
import com.codeclan.example.BookingSystem.Repositiories.CourseRepository.CourseRepository;
import com.codeclan.example.BookingSystem.Repositiories.CustomerRepository.CustomerRepository;
import com.codeclan.example.BookingSystem.models.Booking;
import com.codeclan.example.BookingSystem.models.Course;
import com.codeclan.example.BookingSystem.models.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingSystemApplicationTests {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

	@Test
	public void contextLoads() {
	}

//	basic tests for CRUD functionality
    @Test
    public void canSaveCustomerToDB(){
        Customer customer1 = new Customer("Jim", "Portobello", 26);
        customerRepository.save(customer1);
        assertEquals(1, customerRepository.findAll().size());
    }

    @Test
    public void canSaveCourseToDB() {
        Course course1 = new Course("Pilates", "Portobello", 4);
        courseRepository.save(course1);
        assertEquals(1, courseRepository.findAll().size());
    }

    @Test
    public void canSaveBookingToDB() {
        Course course1 = new Course("Pilates", "Portobello", 4);
        courseRepository.save(course1);

        Customer customer1 = new Customer("Jim", "Portobello", 26);
        customerRepository.save(customer1);

        Booking booking1 = new Booking("01-01-2019", course1, customer1);
        bookingRepository.save(booking1);

        assertEquals(1, bookingRepository.findAll().size());
    }

//    custom tests

    @Test
    public void canFindAllCoursesWithRating4() {
        List<Course> results = courseRepository.getAllCoursesWithRating(4);
    }

}
