package com.codeclan.example.BookingSystem.Repositiories.CustomerRepository;

import com.codeclan.example.BookingSystem.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @Autowired
    EntityManager entityManager;

//  Get all customers for a given course
    @Transactional
    public List<Customer> getAllCustomersForCourse(Long courseId) {

        List<Customer> results = null;

        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria criteria = session.createCriteria(Customer.class);
            criteria.createAlias("bookings", "booking");
            criteria.add(Restrictions.eq("booking.course.id", courseId));
            results = criteria.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return results;

    }

}
