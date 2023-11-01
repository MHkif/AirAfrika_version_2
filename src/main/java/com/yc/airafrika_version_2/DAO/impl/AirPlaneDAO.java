package com.yc.airafrika_version_2.DAO.impl;

import com.yc.airafrika_version_2.DAO.IAirPlane;
import com.yc.airafrika_version_2.Entity.Airplane;
import com.yc.airafrika_version_2.Utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AirPlaneDAO implements IAirPlane {
    @Override
    public Airplane save(Airplane airPlane)  {
        return null;
    }

    @Override
    public Airplane update(Airplane airPlane)  {
        return null;
    }

    @Override
    public Boolean deactivate(Airplane t)  {
        return false;
    }

    @Override
    public Airplane findBy(String id)  {
        Session session = HibernateSessionFactory.get().openSession();
        session.beginTransaction();
        String hql = "FROM Airplane WHERE id = :id";
        Query<Airplane> query = session.createQuery(hql, Airplane.class);
        query.setParameter("id", id);
        Airplane airplane = query.getSingleResultOrNull();
        session.getTransaction().commit();
        session.close();
        return airplane;
    }

    @Override
    public List<Airplane> getAll()  {
        Session session = HibernateSessionFactory.get().openSession();
        session.beginTransaction();
        String hql = "FROM Airplane";
        Query<Airplane> query = session.createQuery(hql, Airplane.class);
        List<Airplane> airplanes = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return airplanes;
    }
}
