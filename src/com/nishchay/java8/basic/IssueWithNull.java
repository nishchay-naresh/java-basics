package com.nishchay.java8.basic;

public class IssueWithNull {

    // Problem - It will throw NullPointerException
    public String getCarInsuranceName(Person person) {
        return person.getCar().getInsurance().getName();
    }

    /*
     *
     * performs a null check every time it dereferences a variable, returning the string
     * “Unknown” if any of the variables traversed in this dereferencing chain is a null value.
     * This clearly scales poorly and compromises the readability
     *
     * */
    public String getCarInsuranceName_defencive_take1(Person person) {
        if (person != null) {
            Car car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getName();
                }
            }
        }
        return "unknown";
    }

    // method has four distinct exit points, making it hardly maintainable.
    public String getCarInsuranceName_defencive_take2(Person person) {
        if (person == null) {
            return "unknown";
        }
        Car car = person.getCar();
        if (car == null) {
            return "unknown";
        }
        Insurance insurance = car.getInsurance();
        if (insurance == null) {
            return "unknown";
        }
        return insurance.getName();
    }

    public class Person {
        private Car car;

        public Car getCar() {
            return car;
        }
    }

    public class Car {
        private Insurance insurance;

        public Insurance getInsurance() {
            return insurance;
        }
    }

    public class Insurance {
        private String name;

        public String getName() {
            return name;
        }
    }

}

