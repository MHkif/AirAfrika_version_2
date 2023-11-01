package com.yc.airafrika_version_2.Entity;

import jakarta.persistence.*;
import com.yc.airafrika_version_2.Enum.PaymentMode;

import java.time.LocalDateTime;


public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "paid_At")
    private LocalDateTime paid_At;

    @Column(name = "mode")
    private PaymentMode mode;

    @OneToOne
    private Booking booking;

    public String getId() {
        return id;
    }

    public Payment setId(String id) {
        this.id = id;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public Payment setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public LocalDateTime getPaid_At() {
        return paid_At;
    }

    public Payment setPaid_At(LocalDateTime paid_At) {
        this.paid_At = paid_At;
        return this;
    }

    public PaymentMode getMode() {
        return mode;
    }

    public Payment setMode(PaymentMode mode) {
        this.mode = mode;
        return this;
    }

    public Booking getBooking() {
        return booking;
    }

    public Payment setBooking(Booking booking) {
        this.booking = booking;
        return this;
    }
}
