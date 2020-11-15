package com.nishchay.java8.streams.flatmap;

import java.util.List;

public class Author {

    private String name;
    private List<Book> books;
    private String country;

    public Author() {
    }

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
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



