package com.yc.airafrika_version_2.DAO.impl;

import com.yc.airafrika_version_2.DAO.IBaggage;
import com.yc.airafrika_version_2.Entity.Baggage;

import java.sql.SQLException;
import java.util.List;

public class BaggageDAO implements IBaggage {
    @Override
    public Baggage save(Baggage baggage) throws SQLException {
        return null;
    }

    @Override
    public Baggage update(Baggage baggage) throws SQLException {
        return null;
    }

    @Override
    public Boolean deactivate(Baggage t) throws SQLException {
        return false;
    }

    @Override
    public Baggage findBy(String id) throws SQLException {
        return null;
    }

    @Override
    public List<Baggage> getAll() throws SQLException {
        return null;
    }
}
