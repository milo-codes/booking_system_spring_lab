package com.codeclan.example.BookingSystem.Repositiories.BookingRepository;

import com.codeclan.example.BookingSystem.models.Booking;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class BookingRepositoryImpl implements BookingRepositoryCustom {

    @Autowired
    EntityManager entityManager;

//    Get all bookings for a given date
    @Transactional
    public List<Booking> getAllBookingsForDate(String date) {

        List<Booking> results = null;

        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria criteria = session.createCriteria(Booking.class);
            criteria.add(Restrictions.eq("date", date));
            results = criteria.list();
        } catch (HibernateException exception) {
            exception.printStackTrace();
        } finally {
            session.close();
        }

        return results;

    }

}
