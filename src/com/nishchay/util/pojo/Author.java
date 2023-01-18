package com.nishchay.util.pojo;

import java.util.List;
import java.util.Optional;

public class Author {

    private String name;
    private List<Book> books;
    private Country country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Country getCountry() {
        return country;
    }

    public Optional<Country> getCountryOptionally() {
        return Optional.of(country);
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", books=" + books +
                ", country='" + country + '\'' +
                '}';
    }

}



