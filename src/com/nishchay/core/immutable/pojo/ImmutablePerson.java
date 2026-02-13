package com.nishchay.core.immutable.pojo;

import java.util.Date;

public class ImmutablePerson {
    private final String name;
    private final Date birthDate;

    public ImmutablePerson(String name, Date birthDate) {
        this.name = name;
        // correct way - Return a Defensive copy
        this.birthDate = new Date(birthDate.getTime());
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        // correct way - Return a copy
        return new Date(birthDate.getTime());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
