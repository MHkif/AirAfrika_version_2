package com.yc.airafrika_version_2.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "baggage")
public class Baggage {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private String baggageType;

    @Column(name = "weight")
    private float weight;

    @ManyToOne
    @JoinColumn(name = "flight", referencedColumnName = "id")
    private Flight flight;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBaggageType() {
        return baggageType;
    }

    public void setBaggageType(String type) {
        this.baggageType = type;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
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
        Baggage baggage = (Baggage) o;
        return id == baggage.id && Float.compare(weight, baggage.weight) == 0 && Objects.equals(baggageType, baggage.baggageType) && Objects.equals(flight, baggage.flight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, baggageType, weight, flight);
    }
}