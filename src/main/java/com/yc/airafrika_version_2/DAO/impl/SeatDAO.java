package com.yc.airafrika_version_2.DAO.impl;

import com.yc.airafrika_version_2.DAO.ISeat;
import com.yc.airafrika_version_2.Entity.Seat;

import java.sql.SQLException;
import java.util.List;

public class SeatDAO implements ISeat {
    @Override
    public Seat save(Seat seat) throws SQLException {
        return null;
    }

    @Override
    public Seat update(Seat seat) throws SQLException {
        return null;
    }

    @Override
    public Boolean deactivate(Seat t) throws SQLException {
        return false;
    }

    @Override
    public Seat findBy(String id) throws SQLException {
        return null;
    }

    @Override
    public List<Seat> getAll() throws SQLException {
        return null;
    }
}
