package com.yc.airafrika_version_2.Services;

import java.sql.SQLException;
import java.util.List;

public interface Service<T> {
    T save(T t);
    T update(T t);
    boolean deactivate(T t);
    T findBy(String id);
    List<T> getAll() throws SQLException;
}
