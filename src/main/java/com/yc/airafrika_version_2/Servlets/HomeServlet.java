package com.yc.airafrika_version_2.Servlets;

import com.yc.airafrika_version_2.Entity.Airplane;
import com.yc.airafrika_version_2.Entity.Airport;
import com.yc.airafrika_version_2.Entity.Flight;
import com.yc.airafrika_version_2.Enum.FlightType;
import com.yc.airafrika_version_2.Services.AirplaneService;
import com.yc.airafrika_version_2.Services.AirportService;
import com.yc.airafrika_version_2.Services.FlightService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "homeServlet", urlPatterns = {"/", "", "/flights"})
public class HomeServlet extends HttpServlet {
    private final FlightService flightService  = new FlightService();
    private final AirplaneService airplaneService = new AirplaneService();
    private final AirportService airportService = new AirportService();
    private String message;

    public void init() {
        message = "Welcome to AirAfrika ";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Flight> flights =  flightService.getAll();
        List<Airport> airPorts = airportService.getAll();
        request.setAttribute("flights", flights);
        request.setAttribute("airPorts", airPorts);
        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        List<Airport> airPorts = airportService.getAll();
        List<Flight> flights =  flightService.find(req.getParameter("departure"), req.getParameter("arrival"), req.getParameter("depart_At"));
        req.setAttribute("flights", flights);
        req.setAttribute("airPorts", airPorts);
        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req,response);
    }

    public void destroy() {
    }
}