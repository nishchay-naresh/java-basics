package com.nishchay.core.immutable;

import com.nishchay.core.immutable.pojo.ImmutablePerson;
import com.nishchay.core.immutable.pojo.Person;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
/*
* write a piece of code, which will break the immutability if not making class attribute as final
*
* */
public class BreakingImmutability {

    public static void main(String[] args) {
        modifyDateMutableObject();
        System.out.println("========================================================================================= ");
        modifyDateImmutableObject();
    }

    private static void modifyDateMutableObject() {

        Date date = new Date();
        Person person = new Person("Alice", date);

        System.out.println("Person Original state   : " + person);

        // Modify original `date` object after creating `Person` by passing a reference through constructor
        date.setTime(0); // Changes internal state of person!
        System.out.println("Person state now        : " + person);

        // Modify original `date` object after creating `Person` by leaking a reference through getter
        Date janFirst2000 = Date.from(LocalDate.of(2000, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        date = person.getBirthDate();
        date.setTime(janFirst2000.getTime());
        System.out.println("Person state now        : " + person);
    }

    private static void modifyDateImmutableObject() {

        Date date = new Date();
        ImmutablePerson person = new ImmutablePerson("Alice", date);

        System.out.println("Person Original state   : " + person);

        // Modify original `date` object after creating `Person` by passing a reference through constructor
        date.setTime(0); // Changes internal state of person!
        System.out.println("Person state now        : " + person);

        // Modify original `date` object after creating `Person` by leaking a reference through getter
        Date janFirst2000 = Date.from(LocalDate.of(2000, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        date = person.getBirthDate();
        date.setTime(janFirst2000.getTime());
        System.out.println("Person state now        : " + person);
    }

}

