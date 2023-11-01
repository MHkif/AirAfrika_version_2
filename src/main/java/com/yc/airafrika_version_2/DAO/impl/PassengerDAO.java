package com.yc.airafrika_version_2.DAO.impl;

import org.hibernate.Session;
import com.yc.airafrika_version_2.DAO.IPassenger;
import com.yc.airafrika_version_2.Entity.*;
import com.yc.airafrika_version_2.Utils.HibernateSessionFactory;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassengerDAO implements IPassenger {

    @Override
    public Passenger save(Passenger passenger) {
        Session session = HibernateSessionFactory.get().openSession();
        session.getTransaction().begin();
        session.persist(passenger);
        session.getTransaction().commit();
        session.close();
        return passenger;
    }

    @Override
    public Passenger update(Passenger passenger) throws SQLException {
        String sql = "UPDATE "+ TABLE +" SET "+UPDATEHOLDERS+" WHERE "+ PRIMARY_KEY +" = ?";
        return null;
    }

    @Override
    public Boolean deactivate(Passenger t) throws SQLException {
        return false;
    }

    @Override
    public Passenger findBy(String id) throws SQLException {
        return null;
    }
    public Passenger findByName(String firstName, String lastName)  {
        Session session = HibernateSessionFactory.get().openSession();
        session.getTransaction().begin();
        String hql = "FROM Passenger WHERE firstname = :firstName AND lastname = :lastName ";

        Query<Passenger> query = session.createQuery(hql, Passenger.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        Passenger passenger = query.getSingleResultOrNull();

        session.getTransaction().commit();
        session.close();
        return passenger;
    }
    @Override
    public List<Passenger> getAll() throws SQLException {
        List<Passenger> passengers = new ArrayList<>();
        String sql = "SELECT * FROM "+ TABLE ;


        return passengers;
    }

    public List<Flight> getFlights() throws SQLException {
        List<Flight> flights = new ArrayList<>();
        return flights;
    }





}
