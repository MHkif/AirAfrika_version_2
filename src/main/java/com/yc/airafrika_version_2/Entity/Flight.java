package com.yc.airafrika_version_2.Entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "depart_at")
    private Date departAt;

    @Column(name = "arrived_at")
    private Date arrivedAt;

    @Column(name = "amount")
    private double amount;

    @Column(name = "type")
    private String flightType;

    @ManyToOne
    @JoinColumn(name = "airplane", referencedColumnName = "id")
    private Airplane airplane;

    @ManyToOne
    @JoinColumn(name = "departure", referencedColumnName = "id")
    private Airport departureAirport;
    @ManyToOne
    @JoinColumn(name = "arrival", referencedColumnName = "id")
    private Airport arrivalAirport;

    /*
    @OneToMany(mappedBy = "flight" )
    private Collection<Escale> escales = new ArrayList<>();
    @OneToMany(mappedBy = "flight")
    private Collection<Extra> extras = new ArrayList<>();



    @ManyToMany()
    @JoinTable(
            name = "booking",
            joinColumns = @JoinColumn(name = "flight"),
            inverseJoinColumns = @JoinColumn(name = "passenger")
    )
    private Collection<Passenger> passengers = new ArrayList<>();

     */

    public Flight() {
    }

    public String getId() {
        return id;
    }
    public Date getDepartAt() {
        return departAt;
    }
    public Date getArrivedAt() {
        return arrivedAt;
    }
    public double getAmount() {
        return amount;
    }
    public String getFlightType() {
        return flightType;
    }
    public Airplane getAirplane() {
        return airplane;
    }
    public Airport getDepartureAirport() {
        return departureAirport;
    }
    public Airport getArrivalAirport() {
        return arrivalAirport;
    }
    /*
    public Collection<Escale> getEscales() {
        return escales;
    }
    public Collection<Extra> getExtras() {
        return extras;
    }



    public Collection<Passenger> getPassengers() {
        return passengers;
    }

     */



    public void setId(String id) {
        this.id = id;
    }
    public void setDepartAt(Date departAt) {
        this.departAt =  departAt;
    }
    public void setArrivedAt(Date arrivedAt) {
        this.arrivedAt = arrivedAt;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }
    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }
    public void setDepartureAirport(Airport departure) {
        this.departureAirport = departure;
    }
    public void setArrivalAirport(Airport arrival) {
        this.arrivalAirport = arrival;
    }
    /*
    public void setEscales(Collection<Escale> escales) {
        this.escales = escales;
    }
    public void setExtras(Collection<Extra> extras) {
        this.extras = extras;
    }
     public void setPassengers(Collection<Passenger> passengers) {
        this.passengers = passengers;
    }
     */



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Double.compare(amount, flight.amount) == 0 && Objects.equals(id, flight.id) && Objects.equals(departAt, flight.departAt) && Objects.equals(arrivedAt, flight.arrivedAt) && Objects.equals(flightType, flight.flightType) && Objects.equals(airplane, flight.airplane) && Objects.equals(departureAirport, flight.departureAirport) && Objects.equals(arrivalAirport, flight.arrivalAirport) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departAt, arrivedAt, amount, flightType, airplane, departureAirport, arrivalAirport);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id='" + id + '\'' +
                ", departAt=" + departAt +
                ", arrivedAt=" + arrivedAt +
                ", amount=" + amount +
                ", flightType='" + flightType + '\'' +
                ", airplane=" + airplane +
                ", departureAirport=" + departureAirport +
                ", arrivalAirport=" + arrivalAirport +

                '}';
    }
}
