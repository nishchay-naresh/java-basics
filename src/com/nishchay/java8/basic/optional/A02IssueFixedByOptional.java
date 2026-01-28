package com.nishchay.java8.basic.optional;

import java.util.Optional;

public class A02IssueFixedByOptional {

    public String getCarInsuranceName(Person person) {
        Optional<Person> optPerson = Optional.of(person);
        return optPerson.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("unknown");
    }

    public String getCarInsuranceName_filter(Optional<Person> optPerson, int minAge) {
        return optPerson.filter(p -> p.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("unknown");
    }


    class Person {
        private Optional<Car> car;
        private int age;

        public Optional<Car> getCar() {
            return car;
        }

        public int getAge() {
            return age;
        }

    }

    class Car {

        private Optional<Insurance> insurance;

        public Optional<Insurance> getInsurance() {
            return insurance;
        }
    }

    class Insurance {

        private String name;

        public String getName() {
            return name;
        }
    }
}
