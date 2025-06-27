package com.nishchay.core.immutable;

import java.util.Collections;
import java.util.Date;
import java.util.List;

// marking class as final, so it can’t be extended further
public final class ImmutableEmp {

    //  direct access is not allowed for member variables, declaring them as private
    //  Marking all mutable fields as final, so that they can only be initialized once in constructor
    //  Because of making the attribute as final in immutable object, we are achieving failure atomicity
    private final Integer id;   // immutable by java
    private final String name;  // immutable by java
    private double sal;         // mutable, but pas by value
    private final Date doj;     // mutable, need to take care at what comes-in (at constructor) what goes-out (at getters)
                                // by creating a defensive copy
    private List<Address> addresses;  // mutable

    public ImmutableEmp() {
        this(0,null,0.00,null,null);
    }

    public ImmutableEmp(Integer id, String name, double sal, Date doj, List<Address> addresses) {
        // Initialize all mutable fields in constructor via deep copy
        // No direct reference is assigned, created a defensive copy and then assigned its reference
        Date copyDOJ = (Date) doj.clone();
        // Returns an unmodifiable view of the specified list
        List<Address> copyAddresses = Collections.unmodifiableList(addresses);

        this.id = id;
        this.name = name;
        this.sal = sal;
        this.doj = copyDOJ;
        this.addresses = copyAddresses;
    }

    //Provide no setter methods
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
        //Perform cloning of objects in the getter methods to return a copy rather than returning the internal mutable object's actual reference
        Date copyDOJ = (Date) doj.clone();
        return copyDOJ;
    }

    public List<Address> getAddresses() {
        List<Address> copyAddresses = Collections.unmodifiableList(addresses);
        return copyAddresses;
    }
}
