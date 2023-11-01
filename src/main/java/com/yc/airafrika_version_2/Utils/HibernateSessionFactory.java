package com.yc.airafrika_version_2.Utils;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibernateSessionFactory {

    private static SessionFactory sessionFactory;


    public static SessionFactory get() {
        if (sessionFactory == null) {
             sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }


}