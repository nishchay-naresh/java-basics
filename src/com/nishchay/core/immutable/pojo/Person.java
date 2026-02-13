package com.nishchay.core.immutable.pojo;

import java.util.Date;

public class Person {
    private String name;                // Not final
    // private final String name;       // correct way - Declare fields as final
    private Date birthDate;             // Not final (and mutable object)

    public Person(){

    }
    public Person(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate; // Reference is assigned, not defensively copied
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate; // Returns internal mutable object reference

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
