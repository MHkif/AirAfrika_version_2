package com.yc.airafrika_version_2.DAO;

import com.yc.airafrika_version_2.Entity.Passenger;

import java.sql.SQLException;

public interface IPassenger extends DAO<Passenger> {
    final String TABLE = "passengers";
    final String ID = "id";
    final String FIRST_NAME = "firstName";
    final String LAST_NAME = "lastName";
    final String EMAIL = "email";
    final String PASSWORD = "password";
    final String PHONE_NUMBER = "phoneNumber";

    final String PRIMARY_KEY  = ID;

    final String[] TABLE_COLUMNS = {
            FIRST_NAME,
            LAST_NAME,
            EMAIL,
            PASSWORD,
            PHONE_NUMBER
    };

    final String COLUMNS = String.join(", ", TABLE_COLUMNS);
    final String HOLDERS = ",?".repeat(TABLE_COLUMNS.length +1).replaceFirst(",", "");
    final String UPDATEHOLDERS = String.join(" = ? ,", TABLE_COLUMNS).replaceAll("()$", " = ? ");

    Passenger save(Passenger passenger) throws SQLException;
}
