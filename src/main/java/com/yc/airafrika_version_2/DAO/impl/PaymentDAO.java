package com.yc.airafrika_version_2.DAO.impl;



import com.yc.airafrika_version_2.DAO.IPayment;
import com.yc.airafrika_version_2.Entity.Payment;

import java.sql.SQLException;
import java.util.List;

public class PaymentDAO implements IPayment {

    @Override
    public Payment save(Payment payment) throws SQLException {
        return null;
    }

    @Override
    public Payment update(Payment payment) throws SQLException {
        return null;
    }

    @Override
    public Boolean deactivate(Payment t) throws SQLException {
        return false;
    }

    @Override
    public Payment findBy(String id) throws SQLException {
        return null;
    }

    @Override
    public List<Payment> getAll() throws SQLException {
        return null;
    }
}
