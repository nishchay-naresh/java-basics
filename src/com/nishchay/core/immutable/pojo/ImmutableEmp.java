package com.nishchay.core.immutable.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/*
 *
 * To create an immutable class in Java, you have to do the following steps:
 *     1. Declare the class as final so it can’t be extended.
 *     2. Make all fields private so that direct access is not allowed.
 *     3. Make all mutable fields final so that its value can be assigned only once.
 *     4. Don’t provide any method that modifies the object’s state, i.e., don’t provide setters methods.
 *     5. Initialize all the fields via a constructor performing deep copy.
 *     6. Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
 * => point 5 & 6 is all about never leak reference for any of the mutable attribute,
 *    Always create a Defensive copies for mutable types and return its reference
 * */

public final class ImmutableEmp {

    private final Integer id;   // immutable by java
    private final String name;  // immutable by java
    private final double sal;   // primitive pass by value
    private final Date doj;     // mutable, need to take care at what comes-in (at constructor) what goes-out (at getters) by creating a defensive copy
    private final List<Address> addresses;  // mutable


    public ImmutableEmp(Integer id, String name, double sal, Date doj, List<Address> addresses) {

        this.id = id;
        this.name = name;
        this.sal = sal;
        // No direct reference is assigned, created a defensive copy and then assigned its reference
        this.doj = new Date(doj.getTime());

        List<Address> copyList = new ArrayList<>();
        for (Address t : addresses) {
            copyList.add(new Address(t));
        }
        this.addresses = Collections.unmodifiableList(copyList); // getting a read-only view for this copyList
    }

    //No setter method is provided
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getSal() {
        return sal;
    }

    public Date getDoj() {
        // return a copy rather than returning the actual reference - using copy constructor
        return new Date(doj.getTime());
    }

    // this class is only immutable iff Address is immutable or return defensive copies in getter
    public List<Address> getAddresses() {
        return addresses; // since it's referring a read-only view of an actual list
    }

    @Override
    public String toString() {
        return "ImmutableEmp{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", sal=" + getSal() +
                ", doj=" + getDoj() +
                ", addresses=" + getAddresses() +
                '}';
    }
}
