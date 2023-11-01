package com.yc.airafrika_version_2.Services;

import com.yc.airafrika_version_2.DAO.impl.PassengerDAO;
import com.yc.airafrika_version_2.Entity.Passenger;
import com.yc.airafrika_version_2.Utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class PassengerService implements Service<Passenger> {

    PassengerDAO passengerDAO = new PassengerDAO();
    @Override
    public Passenger save(Passenger passenger) {
        return passengerDAO.save(passenger);
    }

    @Override
    public Passenger update(Passenger passenger) {
        return null;
    }

    @Override
    public boolean deactivate(Passenger t) {
        return false;
    }

    @Override
    public Passenger findBy(String id) {
        return null;
    }

    public Passenger findByName(String firstName, String lastName){
        return passengerDAO.findByName(firstName, lastName);
    }

    @Override
    public List<Passenger> getAll() {
        return null;
    }
}
