package com.codeclan.example.BookingSystem.Repositiories.CourseRepository;

import com.codeclan.example.BookingSystem.models.Course;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepositoryCustom {

//    custom query methods full

    @Autowired
    EntityManager entityManager;

//    Get all courses with a given rating
    @Transactional
    public List<Course> getAllCoursesWithRating(int rating) {

        List<Course> results = null;

        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria criteria = session.createCriteria(Course.class);
            criteria.add(Restrictions.eq("rating", rating));
            results = criteria.list();
        } catch (HibernateException exception) {
            exception.printStackTrace();
        } finally {
            session.close();
        }

        return results;

    }

}
