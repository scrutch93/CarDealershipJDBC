package com.pluralsight.dealership;

public class Dealership {

    protected int dealershipId;
    protected String name;
    protected String address;
    protected String phone;

    public Dealership(int dealershipId, String name, String address, String phone) {
        this.dealershipId = dealershipId;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
}
