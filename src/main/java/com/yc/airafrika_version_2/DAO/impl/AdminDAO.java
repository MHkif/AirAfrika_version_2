package com.yc.airafrika_version_2.DAO.impl;


import com.yc.airafrika_version_2.Entity.Admin;
import com.yc.airafrika_version_2.Utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AdminDAO  {


    public Admin login(String email, String password)  {
        Session session = HibernateSessionFactory.get().openSession();
        session.beginTransaction();
        String hql = "FROM Admin WHERE email = :email AND password = :password";
        Query<Admin> query = session.createQuery(hql, Admin.class);
        query.setParameter("email", email)
                .setParameter("password", password);

        List<Admin> results = query.getResultList();
        Admin admin = new Admin();
        if (!results.isEmpty()) {
            for (Admin entity : results) {
                admin.setId(entity.getId());
                admin.setFirstname(entity.getFirstname());
                admin.setLastname(entity.getLastname());
                admin.setEmail(entity.getEmail());
                admin.setPassword(entity.getPassword());
                admin.setPhonenumber(entity.getPhonenumber());
            }
            return admin;
        } else {
            System.out.println("No results found.");
        }
        session.getTransaction().commit();
        session.close();
        return  null;
    }

}

