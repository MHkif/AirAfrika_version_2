package com.yc.airafrika_version_2.Services;

import com.yc.airafrika_version_2.DAO.impl.BookingDAO;
import com.yc.airafrika_version_2.Entity.Booking;
import com.yc.airafrika_version_2.Entity.Passenger;
import com.yc.airafrika_version_2.Utils.PrintStatement;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class BookingService implements Service<Booking>{
    private final BookingDAO bookingDAO = new BookingDAO();

    @Override
    public Booking save(Booking booking) {
        return bookingDAO.save(booking);
    }

    @Override
    public Booking update(Booking booking) {
        return null;
    }

    @Override
    public boolean deactivate(Booking booking) {
        if (PrintStatement.comparingDates(booking.getFlight().getDepartAt()) < 1){
            return false;
        }
        booking.setCanceledAt(new Date());
        return bookingDAO.update(booking) != null;

    }

    @Override
    public Booking findBy(String id) {
        return bookingDAO.findBy(id);
    }

    public List<Booking> findByPassenger(Passenger passenger){
        return bookingDAO.findByPassenger(passenger);
    }

    @Override
    public List<Booking> getAll() throws SQLException {
        return null;
    }
}
