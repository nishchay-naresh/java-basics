package com.nishchay.core.immutable.pojo;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/*
 *
 * To create an immutable class in Java, you have to do the following steps:
 *     1. Declare the class as final so it can’t be extended.
 *     2. Make all fields private so that direct access is not allowed.
 *     3. Make all mutable fields final so that its value can be assigned only once.
 *     4. Don’t provide any method that modify the object’s state i.e. don’t provide setters methods.
 *     5. Initialize all the fields via a constructor performing deep copy.
 *     6. Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
 * => point 5 & 6 is all about never leak reference for any of the mutable attribute,
 *    Always create a Defensive copies for mutable types and return its reference
 * */

public final class ImmutableEmp {

    //  Because of making the attribute as final in immutable object, we are achieving failure atomicity
    private final Integer id;   // immutable by java
    private final String name;  // immutable by java
    private final double sal;   // primitive
    private final Date doj;     // mutable, need to take care at what comes-in (at constructor) what goes-out (at getters) by creating a defensive copy
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
        //Perform cloning of objects in the getter methods to return a copy rather than returning the internal mutable object's actual reference
        Date copyDOJ = (Date) doj.clone();
        return copyDOJ;
    }

    public List<Address> getAddresses() {
        List<Address> copyAddresses = Collections.unmodifiableList(addresses);
        return copyAddresses;
    }


}
