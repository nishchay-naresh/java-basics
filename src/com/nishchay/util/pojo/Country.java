package com.nishchay.util.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Country {

    private String name;
    private String ccy;

    public Country(String name) {
        this.name = name;
    }
    public Country(String name, String ccy) {
        this.name = name;
        this.ccy = ccy;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getNameOptionally() {
        return Optional.of(name);
    }

    public static List<Country> getCountries(){
        return Arrays.asList(
                new Country("India", "INR"),
                new Country("United States Of America", "USD"),
                new Country("Japan", "JPN"),
                new Country("United Kingdom", "EUR"),
                new Country("Germany", "GBP")
        );
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", ccy='" + ccy + '\'' +
                '}';
    }

}
