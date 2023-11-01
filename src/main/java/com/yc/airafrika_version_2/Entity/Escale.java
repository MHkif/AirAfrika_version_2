package com.yc.airafrika_version_2.Entity;

import jakarta.persistence.*;


import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "escale")
public class Escale {

    @Id
    @Column(name = "arrived_at")
    private Date arrivedAt;

    @Id
    @Column(name = "depart_at")
    private Date departAt;

    @Id
    @Column(name = "airport")
    private String airport;

    @ManyToOne
    @JoinColumn(name = "flight", referencedColumnName = "id")
    private Flight flight;

    public Escale() {
    }

    public Date getArrivedAt() {
        return arrivedAt;
    }

    public void setArrivedAt(Date arrivedAt) {
        this.arrivedAt = arrivedAt;
    }

    public Date getDepartAt() {
        return departAt;
    }

    public void setDepartAt(Date departAt) {
        this.departAt = departAt;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Escale escale = (Escale) o;
        return Objects.equals(arrivedAt, escale.arrivedAt) && Objects.equals(departAt, escale.departAt) && Objects.equals(airport, escale.airport) && Objects.equals(flight, escale.flight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arrivedAt, departAt, airport, flight);
    }

  }
