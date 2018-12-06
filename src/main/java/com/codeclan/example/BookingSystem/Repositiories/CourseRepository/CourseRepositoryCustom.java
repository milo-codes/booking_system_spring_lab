package com.codeclan.example.BookingSystem.Repositiories.CourseRepository;

import com.codeclan.example.BookingSystem.models.Course;

import java.util.List;

public interface CourseRepositoryCustom {

//    custom method prototypes

    List<Course> getAllCoursesWithRating(int rating);

}
