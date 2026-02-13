package com.nishchay.core.immutable.pojo;

public final class Address {

    private final String city;
    private final int pin;

    public Address(Address other) {
        this.city = other.city;
        this.pin = other.pin;
    }

    public Address(String city, int pin) {
        this.city = city;
        this.pin = pin;
    }

    // no setters to protect the immutability
    public String getCity() {
        return city;
    }

    public int getPin() {
        return pin;
    }

    @Override
    public String toString() {
        return "Address [addLine1=" + city + ", pin=" + pin + "]";
    }
}