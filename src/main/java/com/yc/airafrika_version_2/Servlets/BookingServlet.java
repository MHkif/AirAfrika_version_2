package com.yc.airafrika_version_2.Servlets;


import com.yc.airafrika_version_2.Console.Main;
import com.yc.airafrika_version_2.Entity.Booking;
import com.yc.airafrika_version_2.Entity.Flight;
import com.yc.airafrika_version_2.Entity.Passenger;
import com.yc.airafrika_version_2.Enum.*;
import com.yc.airafrika_version_2.Services.BookingService;
import com.yc.airafrika_version_2.Services.FlightService;
import com.yc.airafrika_version_2.Services.PassengerService;
import com.yc.airafrika_version_2.Utils.UniqueCodeGenerator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Period;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@WebServlet(name = "BookingServlet", value = "/booking")
public class BookingServlet extends HttpServlet {
    private String message;
    private BookingService bookingService ;
    private FlightService flightService;
    private PassengerService passengerService;
    public void init() {
        flightService = new FlightService();
        bookingService = new BookingService();
        passengerService = new PassengerService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String flight_id = request.getParameter("flight_id");
        Flight flight = flightService.findBy(flight_id);
        System.out.println(flight);
        List<ClassType> flightClasses = List.of(ClassType.values());
        List<ExtraType> extras = List.of(ExtraType.values());
        List<BaggageType> baggageTypes = List.of(BaggageType.values());
        List<PaymentMode> paymentModes = List.of(PaymentMode.values());

        long secs = ( flight.getArrivedAt().getTime() - flight.getDepartAt().getTime()) / 1000;
        int hours = Math.toIntExact((secs / 3600));
        secs = secs % 3600;
        int mins = (int) (secs / 60);
        secs = secs % 60;

        request.setAttribute("flight", flight);
        request.setAttribute("durationHours", hours);
        request.setAttribute("durationMins", mins);
        request.setAttribute("flightClasses", flightClasses);
        request.setAttribute("extras", extras);
        request.setAttribute("baggageTypes", baggageTypes);
        request.setAttribute("paymentModes", paymentModes);
        getServletContext().getRequestDispatcher("/WEB-INF/booking.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String flight_id =  req.getParameter("flight_id");
        Flight flight = flightService.findBy(flight_id);
        String flightClass = req.getParameter("flightClass");
        String extras = req.getParameter("extras");
        String extraCost = req.getParameter("extraCost");
        String baggageType = req.getParameter("baggageType");
        String weight = req.getParameter("weight");
        String paymentMode = req.getParameter("paymentMode");
        Passenger passenger = new Passenger();
        passenger.setId(UniqueCodeGenerator.code());
        passenger.setEmail(req.getParameter("email"));
        passenger.setFirstname(req.getParameter("firstName"));
        passenger.setLastname(req.getParameter("lastName"));
        passenger.setPhonenumber(req.getParameter("phone"));
        Passenger CheckPassneger = passengerService.findByName(req.getParameter("firstName"), req.getParameter("lastName"));

        if(CheckPassneger == null){
            passengerService.save(passenger);
            Main.SESSION.set("Passenger", passenger);
        }else {
            passenger = CheckPassneger;
            Main.SESSION.set("Passenger", passenger);
        }


        Main.SESSION.set("civility", req.getParameter("civility"));

        System.out.println("Flight id : "+ flight_id);
        System.out.println("Passenger : "+ passenger);
        double total = 0;
        if(Double.parseDouble(weight) > 0 &&  Double.parseDouble(weight) < 5){
            total += Double.parseDouble(weight) * 250   ;
        }else {
            total += Double.parseDouble(weight) * 180;
        }
         total += Double.parseDouble(extraCost);

        Booking booking = new Booking();
        booking.setRef(UniqueCodeGenerator.code());
        booking.setFlight(flight);
        booking.setPassenger(passenger);
        booking.setStatus(BookingStatus.ON_WAIT_LIST.name());
        Date date = new Date();
        booking.setReservedAt(date);
        booking.setCanceledAt(date);
        booking.setTotal(total);
        if(bookingService.save(booking) != null){
            System.out.println("Booking Successfully");
        }else{
            System.out.println("Booking failed");
        }

        response.sendRedirect("/my-reservations");
        //getServletContext().getRequestDispatcher("/WEB-INF/my_reservations.jsp").forward(req,response);

    }

    public void destroy() {
    }
}
