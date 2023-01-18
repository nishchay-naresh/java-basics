package com.nishchay.util.pojo;

import java.util.Optional;

public class Country {

    private String name;

    public Country(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                '}';
    }

}
