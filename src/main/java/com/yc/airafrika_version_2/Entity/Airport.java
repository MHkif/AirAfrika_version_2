package com.yc.airafrika_version_2.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Airport {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "country")
    private String country;

    public Airport() {
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return id == airport.id && Objects.equals(name, airport.name) && Objects.equals(city, airport.city) && Objects.equals(country, airport.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, country);
    }

    @Override
    public String toString() {
        return "Airport {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
