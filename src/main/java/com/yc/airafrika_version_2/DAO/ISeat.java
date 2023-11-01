package com.yc.airafrika_version_2.DAO;

import com.yc.airafrika_version_2.Entity.Seat;

import java.sql.SQLException;

public interface ISeat extends DAO<Seat>{

    Seat save(Seat seat) throws SQLException;
}
