package com.yc.airafrika_version_2.DAO;

import com.yc.airafrika_version_2.Entity.Flight;

public interface IFlight extends DAO<Flight> {
    final String TABLE = "flights";
    final String ID = "id";
    final String DEPARTURE = "departure";
    final String ARRIVAL = "arrival";
    final String DEPART_At = "depart_At";
    final String ARRIVED_AT = "arrived_At";
    final String AMOUNT = "amount";
    final String TYPE = "type";

    final String PRIMARY_KEY  = ID;

    final String[] TABLE_COLUMNS = {
            DEPARTURE,
            ARRIVAL,
            DEPART_At,
            ARRIVED_AT,
            AMOUNT,
            TYPE
    };

    final String COLUMNS = String.join(", ", TABLE_COLUMNS);
    final String HOLDERS = ",?".repeat(TABLE_COLUMNS.length +1).replaceFirst(",", "");
    final String UPDATEHOLDERS = String.join(" = ? ,", TABLE_COLUMNS).replaceAll("()$", " = ? ");
}
