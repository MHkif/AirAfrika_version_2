package com.yc.airafrika_version_2.Entity;

import com.yc.airafrika_version_2.Enum.ClassType;

public class Seat {
    private int id;
    private int number;
    private ClassType classType;
    private Flight flight;

    public int getId() {
        return id;
    }

    public Seat setId(int id) {
        this.id = id;
        return this;
    }

    public int getNumber() {
        return number;
    }

    public Seat setNumber(int number) {
        this.number = number;
        return this;
    }

    public ClassType getClassType() {
        return classType;
    }

    public Seat setClassType(ClassType classType) {
        this.classType = classType;
        return this;
    }

    public Flight getFlight() {
        return flight;
    }

    public Seat setFlight(Flight flight) {
        this.flight = flight;
        return this;
    }
}
