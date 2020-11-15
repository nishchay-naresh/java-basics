package com.nishchay.java8.streams.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parcel {

    private String name;
    private List<String> items;

    public Parcel(String name, String... items) {
        this.name = name;
        this.items = Arrays.asList(items);
    }

    public List<String> getItems() {
        return items;
    }

    public static void main(String[] args) {
        Parcel amazon = new Parcel("amazon", "Laptop", "Phone");
        Parcel ebay = new Parcel("ebay", "Mouse", "Keyboard");
        List<Parcel> parcels = Arrays.asList(amazon, ebay);

        System.out.println("-------- Without flatMap() ---------------------------");
        List<List<String>> mapReturn = parcels.stream()
                .map(e -> e.getItems())
                .collect(Collectors.toList());
        System.out.println("\t collect() returns: " + mapReturn);

        System.out.println("\n-------- With flatMap() ------------------------------");
        List<String> flatMapReturn = parcels.stream()
                .map(e -> e.getItems())
                .flatMap(e -> e.stream())
                .collect(Collectors.toList());
        System.out.println("\t collect() returns: " + flatMapReturn);
    }
}