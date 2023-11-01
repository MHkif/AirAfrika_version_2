package com.yc.airafrika_version_2.DAO.impl;

import com.yc.airafrika_version_2.DAO.IExtra;
import com.yc.airafrika_version_2.Entity.Extra;

import java.sql.SQLException;
import java.util.List;

public class ExtraDAO implements IExtra {
    @Override
    public Extra save(Extra extra) throws SQLException {
        return null;
    }

    @Override
    public Extra update(Extra extra) throws SQLException {
        return null;
    }

    @Override
    public Boolean deactivate(Extra t) throws SQLException {
        return false;
    }

    @Override
    public Extra findBy(String id) throws SQLException {
        return null;
    }

    @Override
    public List<Extra> getAll() throws SQLException {
        return null;
    }
}
