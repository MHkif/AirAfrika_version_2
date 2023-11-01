package com.yc.airafrika_version_2.Servlets;

import com.yc.airafrika_version_2.Console.Main;
import com.yc.airafrika_version_2.Entity.*;
import com.yc.airafrika_version_2.Enum.BookingStatus;
import com.yc.airafrika_version_2.Enum.FlightType;
import com.yc.airafrika_version_2.Services.BookingService;
import com.yc.airafrika_version_2.Services.FlightService;
import com.yc.airafrika_version_2.Services.PassengerService;
import com.yc.airafrika_version_2.Utils.PrintStatement;
import com.yc.airafrika_version_2.Utils.UniqueCodeGenerator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.print.Book;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@WebServlet(name = "myReservations", urlPatterns = {"/my-reservations", "/my-reservations/find"})
public class MyReservationsServlet extends  HttpServlet{

    private PassengerService passengerService ;
    private FlightService flightService;
    BookingService bookingService;

    public void init()  {
        passengerService = new PassengerService();
        flightService = new FlightService();
        bookingService = new BookingService();
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        if (req.getRequestURI().equals("/my-reservations/find")) {
            findBooking(req, resp);
        } else {
            Passenger passenger = (Passenger) Main.SESSION.get("Passenger");
            List<Booking> reservations = bookingService.findByPassenger(passenger);
            int reservationsCounts = reservations.size();
            req.setAttribute("reservationsCounts", reservationsCounts);
            req.setAttribute("reservations", reservations);
            getServletContext().getRequestDispatcher("/WEB-INF/my_reservations.jsp").forward(req,resp);
        }

    }

    public void findBooking(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException{
        String reservation_ref = req.getParameter("reservation_ref");
        Passenger passenger = passengerService.findByName(req.getParameter("firstName"), req.getParameter("lastName"));
        Booking booking = bookingService.findBy(reservation_ref);

        if(Objects.nonNull(booking) && booking.getCanceledAt() != null){
            System.out.println("This reservation has been cancelled");
            List<Booking> reservations = bookingService.findByPassenger(passenger);
            int reservationsCounts = reservations.size();
            req.setAttribute("cancelled_reservation", reservation_ref);
            req.setAttribute("reservationsCounts", reservationsCounts);
            req.setAttribute("reservations", reservations);
            getServletContext().getRequestDispatcher("/WEB-INF/my_reservations.jsp").forward(req,response);

        }
        else if(Objects.nonNull(booking)){
            if(passenger != null){
                Main.SESSION.set("Passenger", passenger);
                List<Booking> reservations = bookingService.findByPassenger(passenger);
                int reservationsCounts = reservations.size();
                req.setAttribute("reservationsCounts", reservationsCounts);
                req.setAttribute("reservations", reservations);
                getServletContext().getRequestDispatcher("/WEB-INF/my_reservations.jsp").forward(req,response);
            }else{
                System.out.println("Account not found with the provided credentials");
            }
        }
        else{
            System.out.println("Booking not found");
        }



    }

    public void cancel(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String reservation_ref = request.getParameter("reservation_ref");
        Booking booking = bookingService.findBy(reservation_ref);
        if(Objects.nonNull(booking)){
            if(bookingService.deactivate(booking)){
                System.out.println("Booking has been Canceled successfully");
                response.sendRedirect("/my-reservations");
            }else {
                System.out.println("Booking Cancellation has been failed");
            }
        }else{
            System.out.println("Booking Not Found");
        }


    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        cancel(req, resp);

    }
}
