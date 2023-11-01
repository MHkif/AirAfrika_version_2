package com.yc.airafrika_version_2.Console.Controllers;

import com.yc.airafrika_version_2.Console.Main;
import com.yc.airafrika_version_2.Entity.Booking;
import com.yc.airafrika_version_2.Entity.Flight;
import com.yc.airafrika_version_2.Entity.Passenger;
import com.yc.airafrika_version_2.Services.BookingService;
import com.yc.airafrika_version_2.Services.FlightService;
import com.yc.airafrika_version_2.Utils.PrintStatement;
import com.yc.airafrika_version_2.Utils.UniqueCodeGenerator;
import com.yc.airafrika_version_2.Utils.Validator;
import com.yc.airafrika_version_2.Services.AdminService;
import com.yc.airafrika_version_2.Services.PassengerService;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Navigator extends Controller {
    private static Navigator instance;
    private AdminController adminController;


    private final AdminService adminService = new AdminService();
    private final FlightService flightService = new FlightService();
    private final PassengerService passengerService = new PassengerService();
    private  final BookingService bookingService = new BookingService();

    private Navigator(){
        if(Main.SESSION.has("Admin")){
            adminController = new AdminController();
            adminController.index();
        }
        else if(Main.SESSION.has("Passenger")){
            ContinueAsPassenger();
        }
    }

    public static synchronized Navigator INSTANCE(){
        if(instance == null){
            instance = new Navigator();
        }
        return instance;
    }

    public void index(){


        try {
            boolean isRunning = true;
            while (isRunning){

                PrintStatement.opening("AirAfrika Application");
                PrintStatement.indexOptions();
                String option = scanner.nextLine();

                if(Validator.validInteger(option) && Integer.parseInt(option) < 3){
                    switch (Integer.parseInt(option)) {
                        case 0 -> {
                            isRunning = false;
                            Main.SESSION.unset();
                        }
                        case 1 -> this.loginAsAdmin();
                        case 2 -> this.ContinueAsPassenger();
                    }
                }
                else{
                    System.out.println("\nInvalid Entry , Choose one of the following options: ");
                }
            }

        }catch (Exception e){
            System.out.println("Crashed : "+e);
        }

    }

    public void loginAsAdmin(){
        System.out.println("\n");
        System.out.println("Login as admin , Enter your credentials :");
        System.out.print("-> Email : ");
        String email = scanner.nextLine();
        PrintStatement.validateEmailStatement(email);
        System.out.print("-> Password : ");
        String password = scanner.nextLine();
        PrintStatement.validatePasswordStatement(password);

        try {
            if(adminService.login(email, password) != null){
                Main.SESSION.set("Admin", adminService.login(email, password));
                adminController = new AdminController();
                adminController.index();
            }else {
                System.out.println("Admin not found .");
                PrintStatement.backToMenu();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void ContinueAsPassenger(){
        PrintStatement.opening("AirAfrika Application");
        System.out.println("\nAll Flights : \n");

        for(Flight flight: flightService.getAll()) {
         PrintStatement.displayFlight(flight);
        }
        System.out.println("-> Tap any key to Booking now ");
        String s = scanner.nextLine();
        PrintStatement.opening("Booking A Flight");
        Flight flight = PrintStatement.selectFlight(flightService);
        PrintStatement.opening("Passenger Information");

        System.out.print("-> First name : ");
        String firstName = scanner.nextLine();
        PrintStatement.validateNameStatement(firstName, "First name");

        System.out.print("-> Last name : ");
        String lastName = scanner.nextLine();
        PrintStatement.validateNameStatement(lastName, "Last name");

        System.out.print("-> Email : ");
        String email = scanner.nextLine();
        PrintStatement.validateEmailStatement(email);

        System.out.print("-> Phone number : ");
        String phoneNumber = scanner.nextLine();
        PrintStatement.validateNumberStatement( phoneNumber, "Phone number");

        Passenger passenger = new Passenger();

        passenger.setId(UniqueCodeGenerator.code());
        passenger.setFirstname(firstName);
        passenger.setLastname(lastName);
        passenger.setEmail(email);
        passenger.setPhonenumber(phoneNumber);

        if(passengerService.save(passenger) != null){
            Main.SESSION.set("Passenger", passenger);
            Booking bookingEntity = new Booking();
            bookingEntity.setRef(UniqueCodeGenerator.code());
            bookingEntity.setFlight(flight);
            bookingEntity.setPassenger(passenger);
            bookingEntity.setReservedAt(Timestamp.valueOf(LocalDateTime.now()));
            if (bookingService.save(bookingEntity) != null){
                System.out.println("Booking has been made successfully");
            }else{
                System.out.println("Booking has been failed");
            }
        }else{
            System.out.println("Creation of Passenger has been Failed");
        }

        PrintStatement.backToMenu();
    }
}
