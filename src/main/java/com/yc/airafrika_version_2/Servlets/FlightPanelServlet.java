package com.yc.airafrika_version_2.Servlets;

import com.yc.airafrika_version_2.Console.Main;
import com.yc.airafrika_version_2.Entity.Airplane;
import com.yc.airafrika_version_2.Entity.Airport;
import com.yc.airafrika_version_2.Entity.Flight;
import com.yc.airafrika_version_2.Enum.FlightType;
import com.yc.airafrika_version_2.Services.AirplaneService;
import com.yc.airafrika_version_2.Services.AirportService;
import com.yc.airafrika_version_2.Services.FlightService;
import com.yc.airafrika_version_2.Utils.PrintStatement;
import com.yc.airafrika_version_2.Utils.UniqueCodeGenerator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "flightPanelServlet", urlPatterns = {"/flightPanel", "/flightPanel/flight/create","/flightPanel/flight/update", "/flightPanel/flight/delete"})
public class FlightPanelServlet extends HttpServlet {
    private final FlightService flightService  = new FlightService();
    private final AirplaneService airplaneService = new AirplaneService();
    private final AirportService airportService = new AirportService();
    private String message;

    public void init()  {
        message = "Welcome to Flight Panel";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(Main.SESSION.get("Admin") == null){
            System.out.println("No Admin");
            response.sendRedirect("/adminAuth");
        }else {
            if (request.getRequestURI().equals("/flightPanel/flight/update")) {
                updateGet(request, response);
            } else if (request.getRequestURI().equals("/flightPanel/flight/delete")) {
                delete(request, response);
            } else {
                List<Flight> flights = flightService.getAll();
                List<Airplane> airPlanes = airplaneService.getAll();
                List<Airport> airPorts = airportService.getAll();
                List<FlightType> flightTypes = List.of(FlightType.values());
                request.setAttribute("flights", flights);
                request.setAttribute("airPlanes", airPlanes);
                request.setAttribute("airPorts", airPorts);
                request.setAttribute("flightTypes", flightTypes);
                getServletContext().getRequestDispatcher("/WEB-INF/flightPanel.jsp").forward(request, response);
            }
        }
    }

    public void updateGet(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException{
        String flight_id = req.getParameter("flight_id");
        Flight flight = flightService.findBy(flight_id);
        List<Airplane> airPlanes = airplaneService.getAll();
        List<Airport> airPorts = airportService.getAll();
        List<FlightType> flightTypes = List.of(FlightType.values());

        req.setAttribute("flight", flight);
        req.setAttribute("airPlanes", airPlanes);
        req.setAttribute("airPorts", airPorts);
        req.setAttribute("flightTypes", flightTypes);
        getServletContext().getRequestDispatcher("/WEB-INF/flight/update.jsp").forward(req, response);

    }

    public void updatePost(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException{
        String flight_id = req.getParameter("flight_id");
        System.out.println("Flight_id : "+flight_id);
        Flight flight = flightService.findBy(flight_id);

        Airplane airplane =  airplaneService.findBy(req.getParameter("airPlane"));
        Airport departureAirport = airportService.findBy(req.getParameter("departureAirport"));
        Airport arrivalAirport = airportService.findBy(req.getParameter("arrivalAirport"));
        System.out.println("Date departure : " + req.getParameter("date_depart"));
        Date depart_At, arriaved_At;
        try {
            depart_At = PrintStatement.parsingDateTime(req.getParameter("date_depart"));
            arriaved_At = PrintStatement.parsingDateTime(req.getParameter("date_arrival"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        flight.setAirplane(airplane);
        flight.setDepartureAirport(departureAirport);
        flight.setArrivalAirport(arrivalAirport);
        flight.setDepartAt(depart_At);
        flight.setArrivedAt(arriaved_At);
        flight.setFlightType(req.getParameter("flightType"));
        flight.setAmount(Double.parseDouble(req.getParameter("amount")));

        if(Objects.nonNull(flightService.update(flight))){
            response.sendRedirect("/flightPanel");
        }else{
            System.out.println("Flight update has been failed");
        }

    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String flight_id = request.getParameter("flight_id");
        System.out.println("Flight id : "+flight_id);
        Flight flight = flightService.findBy(flight_id);
        if(Objects.nonNull(flight)){
            if(flightService.deactivate(flight)){
                System.out.println("Flight has been deleted successfully");
                response.sendRedirect("/flightPanel");
            }else {
                System.out.println("Flight deletion has been failed");
            }
        }else{
            System.out.println("Flight Not Found");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        if(Main.SESSION.get("Admin") == null){
            System.out.println("No Admin");
            response.sendRedirect("/adminAuth");
        }else{
            if(req.getRequestURI().equals("/flightPanel/flight/create")){
                Flight flight = new Flight();
                Airplane airplane =  airplaneService.findBy(req.getParameter("airPlane"));
                Airport departureAirport = airportService.findBy(req.getParameter("departureAirport"));
                Airport arrivalAirport = airportService.findBy(req.getParameter("arrivalAirport"));
                System.out.println("Date departure : " + req.getParameter("date_depart"));
                Date depart_At, arriaved_At;
                try {
                    depart_At = PrintStatement.parsingDateTime(req.getParameter("date_depart"));
                    arriaved_At = PrintStatement.parsingDateTime(req.getParameter("date_arrival"));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                flight.setId(UniqueCodeGenerator.code());
                flight.setAirplane(airplane);
                flight.setDepartureAirport(departureAirport);
                flight.setArrivalAirport(arrivalAirport);
                flight.setDepartAt(depart_At);
                flight.setArrivedAt(arriaved_At);
                flight.setFlightType(req.getParameter("flightType"));
                flight.setAmount(Double.parseDouble(req.getParameter("amount")));

                if(Objects.nonNull(flightService.save(flight))){
                    response.sendRedirect("/flightPanel");
                }else{
                    System.out.println("Flight creation has been failed");
                }
            }
            else if(req.getRequestURI().equals("/flightPanel/flight/update")){
                updatePost(req, response);
            }
        }

    }

    public void destroy() {
    }
}