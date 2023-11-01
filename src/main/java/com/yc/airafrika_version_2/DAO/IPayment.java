package com.yc.airafrika_version_2.DAO;

import com.yc.airafrika_version_2.Entity.Payment;

import java.sql.SQLException;

public interface IPayment extends DAO<Payment>{
    Payment save(Payment payment) throws SQLException;
}
