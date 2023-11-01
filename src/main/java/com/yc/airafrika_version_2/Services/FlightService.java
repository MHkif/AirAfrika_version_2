package com.yc.airafrika_version_2.Services;

import com.yc.airafrika_version_2.DAO.impl.AirPortDAO;
import com.yc.airafrika_version_2.Entity.Airport;
import org.hibernate.Session;
import com.yc.airafrika_version_2.DAO.impl.FlightDAO;
import com.yc.airafrika_version_2.Entity.Flight;
import com.yc.airafrika_version_2.Utils.HibernateSessionFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class FlightService implements Service<Flight> {

    private final FlightDAO flightDAO = new FlightDAO();
    private final AirPortDAO airPortDAO = new AirPortDAO();
    @Override
    public Flight save(Flight flight) {
        Flight flight_saved = flightDAO.save(flight);
        return Objects.nonNull(flight_saved) ?
                flight_saved : null;
    }

    @Override
    public Flight update(Flight flight) {
        Flight flight_updated = flightDAO.update(flight);
        return Objects.nonNull(flight_updated) ?
                flight_updated : null;
    }

    @Override
    public boolean deactivate(Flight flight) {
        return flightDAO.deactivate(flight);
    }

    @Override
    public Flight findBy(String id) {
        return  flightDAO.findBy(id);
    }

    public List<Flight> find(String departure, String arrival, String date){
        Date depart_At;
        Airport departureAirport = airPortDAO.findBy(departure);
        Airport arrivalAirport = airPortDAO.findBy(arrival);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
             depart_At = formatter.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        // Convert the Date to LocalDate
        LocalDate nextDay = depart_At.toInstant().atZone(ZoneId.systemDefault())
                             .toLocalDate().plusDays(1);

        Date nextDayDate = Date.from(nextDay.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return  flightDAO.find(departureAirport, arrivalAirport, depart_At, nextDayDate);
    }


    @Override
    public List<Flight> getAll() {
        return flightDAO.getAll();
    }
}
