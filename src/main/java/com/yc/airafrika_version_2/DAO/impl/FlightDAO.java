package com.yc.airafrika_version_2.DAO.impl;

import com.yc.airafrika_version_2.Entity.Airport;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.yc.airafrika_version_2.DAO.IFlight;
import com.yc.airafrika_version_2.Entity.Flight;
import com.yc.airafrika_version_2.Utils.HibernateSessionFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightDAO implements IFlight {
    @Override
    public Flight save(Flight flight)  {
        Session session = HibernateSessionFactory.get().openSession();
        session.getTransaction().begin();
        session.persist(flight);
        session.getTransaction().commit();
        session.close();
        return flight;
    }

    @Override
    public Flight update(Flight flight) {
        Session session = HibernateSessionFactory.get().openSession();
        session.getTransaction().begin();
        session.update(flight);
        session.getTransaction().commit();
        session.close();
        return flight;
    }

    @Override
    public Boolean deactivate(Flight flight)  {
        Session session = HibernateSessionFactory.get().openSession();
        session.beginTransaction();
        String hql = "DELETE FROM Flight WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", flight.getId());
        int rowCount = query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return rowCount > 0 ;
    }

    @Override
    public Flight findBy(String id)  {
        Session session = HibernateSessionFactory.get().openSession();
        session.beginTransaction();
        String hql = "FROM Flight WHERE id = :id AND departAt >= current_timestamp() ORDER BY departAt DESC";
        Query<Flight> query = session.createQuery(hql, Flight.class);
        query.setParameter("id", id);

        Flight flight = query.getSingleResultOrNull();

        session.getTransaction().commit();
        session.close();
        return  flight;
    }

    public List<Flight> find(Airport departure, Airport arrival, Date date, Date nextDayDate )  {
        List<Flight> flights = new ArrayList<>();
        Session session = HibernateSessionFactory.get().openSession();
        session.beginTransaction();
        String hql = "FROM Flight WHERE departureAirport = :departure AND arrivalAirport = :arrival " +
                "AND departAt BETWEEN :startDate AND :endDate";

        Query<Flight> query = session.createQuery(hql, Flight.class);
        query.setParameter("departure", departure);
        query.setParameter("arrival", arrival);
        query.setParameter("startDate", date);
        query.setParameter("endDate", nextDayDate);
        List<Flight> results = query.getResultList();

        if (!results.isEmpty()) {
            for (Flight entity : results) {
                Flight flight = new Flight();
                flight.setId(entity.getId());
                flight.setAirplane(entity.getAirplane());
                flight.setDepartureAirport(entity.getDepartureAirport());
                flight.setArrivalAirport(entity.getArrivalAirport());
                flight.setDepartAt(entity.getDepartAt());
                flight.setArrivedAt(entity.getArrivedAt());
                flight.setAmount(entity.getAmount());
                flight.setFlightType(entity.getFlightType());
                flights.add(flight);
            }
        } else {
            System.out.println("No Flights found.");
        }
        session.getTransaction().commit();
        session.close();
        return  flights;
    }

    @Override
    public List<Flight> getAll()  {
        Session session = HibernateSessionFactory.get().openSession();
        session.beginTransaction();
        String hql = "FROM Flight  WHERE departAt >= current_timestamp() ORDER BY id asc ";
        Query<Flight> query = session.createQuery(hql, Flight.class);
        List<Flight> flights = query.getResultList();

        session.getTransaction().commit();
        session.close();
        return flights;
    }





}
