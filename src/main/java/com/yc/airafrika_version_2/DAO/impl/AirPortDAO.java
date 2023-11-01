package com.yc.airafrika_version_2.DAO.impl;

import com.yc.airafrika_version_2.DAO.IAirPort;
import com.yc.airafrika_version_2.Entity.Airport;
import com.yc.airafrika_version_2.Utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AirPortDAO implements IAirPort {
    @Override
    public Airport save(Airport airPort)  {
        return null;
    }

    @Override
    public Airport update(Airport airPort) {
        return null;
    }

    @Override
    public Boolean deactivate(Airport t)  {
        return false;
    }

    @Override
    public Airport findBy(String id)  {
        Session session = HibernateSessionFactory.get().openSession();
        session.beginTransaction();
        String hql = "FROM Airport WHERE id = :id";
        Query<Airport> query = session.createQuery(hql, Airport.class);
        query.setParameter("id", id);
        Airport airport = query.getSingleResultOrNull();
        session.getTransaction().commit();
        session.close();
        return  airport;
    }

    @Override
    public List<Airport> getAll() {
        Session session = HibernateSessionFactory.get().openSession();
        session.beginTransaction();
        String hql = "FROM Airport ORDER BY id asc ";
        Query<Airport> query = session.createQuery(hql, Airport.class);
        List<Airport> airports = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return airports;
    }
}
