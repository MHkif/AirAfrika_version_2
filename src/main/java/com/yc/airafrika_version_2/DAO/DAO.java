package com.yc.airafrika_version_2.DAO;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

    T save(T t) throws SQLException;
    T update(T t) throws SQLException;
    Boolean deactivate(T t) throws SQLException;
    T findBy(String id) throws SQLException;
    List<T> getAll() throws SQLException;
}

