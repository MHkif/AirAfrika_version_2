package com.yc.airafrika_version_2.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "airplane")
public class Airplane {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "capacity")
    private int capacity;

    public Airplane() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airplane airplane = (Airplane) o;
        return id == airplane.id && capacity == airplane.capacity && Objects.equals(name, airplane.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, capacity);
    }
}


