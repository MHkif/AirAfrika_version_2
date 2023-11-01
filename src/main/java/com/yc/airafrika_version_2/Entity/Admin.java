package com.yc.airafrika_version_2.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "firstname")
    private String firstname;

    @Basic
    @Column(name = "lastname")
    private String lastname;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "phonenumber")
    private String phonenumber;


    public Admin(){

    }


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(id, admin.id) && Objects.equals(firstname, admin.firstname) && Objects.equals(lastname, admin.lastname) && Objects.equals(email, admin.email) && Objects.equals(password, admin.password) && Objects.equals(phonenumber, admin.phonenumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, email, password, phonenumber);
    }
}
