package com.yc.airafrika_version_2.Servlets;

import com.yc.airafrika_version_2.Entity.Flight;
import com.yc.airafrika_version_2.Services.FlightService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "flightDetails", value = "/flights/find")
public class FlightDetails extends HttpServlet {

    private FlightService flightService ;

    public void init()  {
        flightService = new FlightService();
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flight_id = req.getParameter("flight_id");
        Flight flight = flightService.findBy(flight_id);
        req.setAttribute("flight", flight);
        getServletContext().getRequestDispatcher("/WEB-INF/flightDetails.jsp").forward(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
