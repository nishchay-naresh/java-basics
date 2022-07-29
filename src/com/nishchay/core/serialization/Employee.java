package com.nishchay.core.serialization;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = -367591245516138230L;

	private final transient int SSN;
	private final String name;
	private final String address;
	private final int salary;

	public Employee(int ssn, String name, String address, int salary) {
		super();
		this.SSN = ssn;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"SSN=" + SSN +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", salary=" + salary +
				'}';
	}

}
