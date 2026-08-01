package com.guilherme.example.demo.models;

public class Vehicle {

    private double price;
    private double entryValue;
    private double tax;
    private int time;

    public Vehicle(double price, double entryValue, double tax, int time) {

        this.price = price;
        this.entryValue = entryValue;
        this.tax = tax;
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public double getEntryValue() {
        return entryValue;
    }

    public double getTax() {
        return tax;
    }

    public int getTime() {
        return time;
    }
}