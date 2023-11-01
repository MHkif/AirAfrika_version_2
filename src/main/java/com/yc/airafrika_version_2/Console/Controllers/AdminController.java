package com.yc.airafrika_version_2.Console.Controllers;

import com.yc.airafrika_version_2.Console.Main;
import com.yc.airafrika_version_2.Entity.Admin;
import com.yc.airafrika_version_2.Entity.Airplane;
import com.yc.airafrika_version_2.Entity.Airport;
import com.yc.airafrika_version_2.Entity.Flight;
import com.yc.airafrika_version_2.Enum.FlightType;
import com.yc.airafrika_version_2.Services.AirplaneService;
import com.yc.airafrika_version_2.Services.AirportService;
import com.yc.airafrika_version_2.Utils.PrintStatement;
import com.yc.airafrika_version_2.Utils.UniqueCodeGenerator;
import com.yc.airafrika_version_2.Utils.Validator;
import com.yc.airafrika_version_2.Services.FlightService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

public class AdminController extends Controller {
    private Admin admin;
    private static final FlightService flightService = new FlightService();
    private static final AirportService airportService = new AirportService();
    private static final AirplaneService airplaneService = new AirplaneService();



    public AdminController() {
        if(!Main.SESSION.has("Admin")){
            Navigator.INSTANCE().index();
        }else {
            this.admin = (Admin) Main.SESSION.get("Admin");
        }
    }

    public  void index(){
        PrintStatement.opening("Admin Panel");
        try {

            boolean isRunning = true;

            while (isRunning){
                PrintStatement.adminOptions();
                String option = scanner.nextLine();
                if(Validator.validInteger(option)){
                    switch (Integer.parseInt(option)) {
                        case 0 -> {
                            isRunning = false;
                            Main.SESSION.remove("Admin");
                        }
                        case 1 -> this.createFlight();
                        case 2 -> this.updateFlight();
                        case 3 -> this.findFlight();
                        case 4 -> this.getAllFlights();
                        case 5 -> this.deactivateFlight();
                    }
                }
                else{
                    System.out.println("\nInvalid Entry , Choose one of the following options: ");
                }
            }

        }catch (Exception e){
            System.out.println("Crashed [From "+this.getClass().getName()+" ] : "+ e);
        }
    }

    public void createFlight() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD", Locale.ENGLISH);
        PrintStatement.opening("Create new Flight");
        Flight flight = new Flight();

        System.out.print("-> AirPlane : ");
        Airplane airplane = PrintStatement.airPlanes(airplaneService.getAll());


        System.out.print("-> Departure Airport : ");

        Airport departure = PrintStatement.airPorts(airportService.getAll(), Optional.empty());

        System.out.print("-> Arrival Airport : ");
        Airport arrival = PrintStatement.airPorts(airportService.getAll(), Optional.ofNullable(departure));


        System.out.print("-> Departure Date : ");
        String depart = scanner.nextLine();
        PrintStatement.validateDateStatement(depart, "Departure Date");
        Date depart_date = formatter.parse(depart);

        System.out.print("-> Arrival Date : ");
        String arrived = scanner.nextLine();
        PrintStatement.validateDateStatement(arrived, "Arrival Date");
        Date arrived_date = formatter.parse(arrived);

        System.out.print("-> Amount : ");
        String amount = scanner.nextLine();
        PrintStatement.validateNumberStatement(amount, "Amount");

        FlightType flightType =  PrintStatement.flightTypes(flight);


        flight.setId(UniqueCodeGenerator.code());
        flight.setDepartureAirport(departure);
        flight.setArrivalAirport(arrival);
        flight.setDepartAt(depart_date);
        flight.setArrivedAt(arrived_date);
        flight.setAirplane(airplane);
        flight.setAmount(Double.parseDouble(amount));
        flight.setFlightType(String.valueOf(flightType));
        System.out.println(flight);

        if(flightService.save(flight) != null){
            System.out.println("Flight has been created successfully");

        }else{
            System.out.println("Creation of Flight has been Failed");
        }
    }

    public void updateFlight(){

        PrintStatement.opening("Update A Flight");

        System.out.print("-> Enter Flight id : ");
        String flightId = scanner.nextLine();
        PrintStatement.validateIdStatement(flightId, "agent");

        if(Objects.nonNull(flightService.findBy(flightId))){
            Flight flight = flightService.findBy(flightId);
            PrintStatement.UpdateFlightOptions(flight);

            System.out.println(flight.toString());

            if(flightService.update(flight) != null){
                System.out.println("Flight has been updated successfully");
            }else{
                System.out.println("Update of Flight has been Failed");
            }

        }else{
            System.out.println("No Flight found with the provided id .");

        }
    }

    public void findFlight(){
        System.out.print("-> Enter Flight id : ");
        String flightId = scanner.nextLine();
        PrintStatement.validateIdStatement(flightId, "Flight");

        if(flightService.findBy(flightId) != null ){
            System.out.println(flightService.findBy(flightId).toString());
        }else{
            System.out.println("No Flight found with the provided id .");
        }

    }

    public void getAllFlights(){
        flightService.getAll().forEach(System.out::println);
    }

    public void deactivateFlight() {
        System.out.print("-> Enter Flight id : ");
        String flightId = scanner.next();
        Flight flight = flightService.findBy(flightId);
        PrintStatement.validateIdStatement(flightId , "Flight");
        if (flightService.findBy(flightId) != null) {

            if (flightService.deactivate(flight)) {
                System.out.println("Flight has been deactivated successfully .");
            } else {
                System.out.println("Deactivation of Flight has been Failed");
            }

        } else {
            System.out.println("No Flight found with the provided id .");

        }
    }
}