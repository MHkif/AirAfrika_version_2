package com.yc.airafrika_version_2.DAO.impl;

import com.yc.airafrika_version_2.Entity.Passenger;
import org.hibernate.Session;
import com.yc.airafrika_version_2.DAO.IBooking;
import com.yc.airafrika_version_2.Entity.Booking;
import com.yc.airafrika_version_2.Utils.HibernateSessionFactory;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO implements IBooking {
    @Override
    public Booking save(Booking booking)  {
        Session session = HibernateSessionFactory.get().openSession();
        session.getTransaction().begin();
        session.persist(booking);
        session.getTransaction().commit();
        session.close();
        return booking;
    }

    @Override
    public Booking update(Booking booking)  {
        Session session = HibernateSessionFactory.get().openSession();
        session.getTransaction().begin();
        session.update(booking);
        session.getTransaction().commit();
        session.close();
        return booking;
    }

    @Override
    public Boolean deactivate(Booking t)  {
        return false;
    }

    @Override
    public Booking findBy(String ref)  {
        Session session = HibernateSessionFactory.get().openSession();
        session.beginTransaction();
        String hql = "FROM Booking WHERE ref = :ref";
        Query<Booking> query = session.createQuery(hql, Booking.class);
        query.setParameter("ref", ref);

        Booking booking = query.getSingleResultOrNull();

        session.getTransaction().commit();
        session.close();
        return booking;
    }

    public List<Booking> findByPassenger(Passenger passenger){
        List<Booking> reservations = new ArrayList<>();
        Session session = HibernateSessionFactory.get().openSession();
        session.beginTransaction();
        String hql = "FROM Booking WHERE passenger = :passenger AND canceledAt IS NULL";
        Query<Booking> query = session.createQuery(hql, Booking.class);
        query.setParameter("passenger", passenger);

        List<Booking> results = query.getResultList();


        if (!results.isEmpty()) {
            for (Booking entity : results) {
                Booking booking = new Booking();
                booking.setRef(entity.getRef());
                booking.setPassenger(entity.getPassenger());
                booking.setFlight(entity.getFlight());
                booking.setReservedAt(entity.getReservedAt());
                booking.setCanceledAt(entity.getCanceledAt());
                booking.setStatus(entity.getStatus());
                booking.setTotal(entity.getTotal());
                reservations.add(booking);
            }
        } else {
            System.out.println("No Booking found for this passenger.");
        }
        session.getTransaction().commit();
        session.close();
        return reservations;
    }
    @Override
    public List<Booking> getAll() throws SQLException {
        return null;
    }
}
