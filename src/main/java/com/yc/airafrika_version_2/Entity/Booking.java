package com.yc.airafrika_version_2.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity

public class Booking {
    @Id
    @Column(name = "ref")
    private String ref;

    @ManyToOne
    @JoinColumn(name = "passenger")
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "flight")
    private Flight flight;
    @Basic
    @Column(name = "reserved_at")
    private Date reservedAt;
    @Basic
    @Column(name = "canceled_at")
        private Date canceledAt;
    @Basic
    @Column(name = "status")
    private String status;

    @Basic
    @Column(name = "total")
    private double total;

    public Booking() {
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Date getReservedAt() {
        return reservedAt;
    }

    public void setReservedAt(Date reservedAt) {
        this.reservedAt = reservedAt;
    }

    public Date getCanceledAt() {
        return canceledAt;
    }

    public void setCanceledAt(Date canceledAt) {
        this.canceledAt = canceledAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(ref, booking.ref) && Objects.equals(passenger, booking.passenger) && Objects.equals(flight, booking.flight) && Objects.equals(reservedAt, booking.reservedAt) && Objects.equals(canceledAt, booking.canceledAt) && Objects.equals(status, booking.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ref, passenger, flight, reservedAt, canceledAt, status);
    }


}
