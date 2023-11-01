package com.yc.airafrika_version_2.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Extra {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "amount")
    private double amount;

    public Extra() {
    }

    @ManyToOne
    @JoinColumn(name = "flight", referencedColumnName = "id")



    private Flight flight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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
        Extra extra = (Extra) o;
        return id == extra.id && Double.compare(amount, extra.amount) == 0 && Objects.equals(type, extra.type) && Objects.equals(flight, extra.flight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, amount, flight);
    }

}
