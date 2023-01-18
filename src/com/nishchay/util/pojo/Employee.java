/*
 * Copyright (c) 2016-2018 Software AG, Darmstadt, Germany and/or Software AG USA Inc., Reston, VA, USA, and/or its subsidiaries and/or its affiliates and/or their licensors.
 * Use, reproduction, transfer, publication or disclosure is prohibited except as specifically provided for in your License Agreement with Software AG.
 */

package com.nishchay.util.pojo;


import java.util.Objects;


/**
 * Employee class containing all existing seven cell types used for its attribute definition.
 * This class will be used for various integration testing
 */
public final class Employee implements Comparable<Employee> {

    private Integer empID;
    private String name;
    private Character gender;
    private Long telephone;
    private Boolean current;
    private Integer ssn;
    private Double salary;
    private Integer birthDay;
    private Integer birthMonth;
    private Integer birthYear;
    private Integer houseNumber;
    private String streetAddress;
    private String cityAddress;
    private String countryAddress;
    private Double bonus;
    private Long cellNumber;

    private Employee() {
    }
    //     public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
    public Employee(int empID,
                    String name,
                    char gender,
                    long telephone,
                    boolean current,
                    int ssn,
                    double salary,
                    int birthDay,
                    int birthMonth,
                    int birthYear,
                    int houseNumber,
                    String streetAddress,
                    String cityAddress,
                    String countryAddress,
                    double bonus,
                    long cellNumber) {

        this.empID = empID;
        this.name = name;
        this.gender = gender;
        this.telephone = telephone;
        this.current = current;
        this.ssn = ssn;
        this.salary = salary;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.houseNumber = houseNumber;
        this.streetAddress = streetAddress;
        this.cityAddress = cityAddress;
        this.countryAddress = countryAddress;
        this.bonus = bonus;
        this.cellNumber = cellNumber;
    }

    public Integer getEmpID() {
        return empID;
    }

    public String getName() {
        return name;
    }

    public Character getGender() {
        return gender;
    }

    public Long getTelephone() {
        return telephone;
    }

    public Boolean getCurrent() {
        return current;
    }

    public Integer getSsn() {
        return ssn;
    }

    public Double getSalary() {
        return salary;
    }

    public Integer getBirthDay() {
        return birthDay;
    }

    public Integer getBirthMonth() {
        return birthMonth;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCityAddress() {
        return cityAddress;
    }

    public String getCountryAddress() {
        return countryAddress;
    }

    public Double getBonus() {
        return bonus;
    }

    public Long getCellNumber() {
        return cellNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Employee)) {
            return false;
        }

        Employee employee = (Employee) o;

        return (Objects.equals(empID, employee.empID) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(gender, employee.gender) &&
                Objects.equals(telephone, employee.telephone) &&
                Objects.equals(current, employee.current) &&
                Objects.equals(ssn, employee.ssn) &&
                Objects.equals(salary, employee.salary) &&
                Objects.equals(birthDay, employee.birthDay) &&
                Objects.equals(birthMonth, employee.birthMonth) &&
                Objects.equals(birthYear, employee.birthYear) &&
                Objects.equals(houseNumber, employee.houseNumber) &&
                Objects.equals(streetAddress, employee.streetAddress) &&
                Objects.equals(cityAddress, employee.cityAddress) &&
                Objects.equals(countryAddress, employee.countryAddress) &&
                Objects.equals(bonus, employee.bonus) &&
                Objects.equals(cellNumber, employee.cellNumber));
    }

    @Override
    public int hashCode() {
        return empID;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empID=" + empID +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", telephone=" + telephone +
                ", current=" + current +
                ", ssn=" + ssn +
                ", salary=" + salary +
                ", birthDay=" + birthDay +
                ", birthMonth=" + birthMonth +
                ", birthYear=" + birthYear +
                ", houseNumber=" + houseNumber +
                ", streetAddress='" + streetAddress + '\'' +
                ", cityAddress='" + cityAddress + '\'' +
                ", countryAddress='" + countryAddress + '\'' +
                ", bonus=" + bonus +
                ", cellNumber=" + cellNumber +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return empID.compareTo(o.empID);
    }

}
