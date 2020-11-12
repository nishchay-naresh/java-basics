package com.nishchay.core.immutable;

public class Address {

	private String addLine1;
	private String addLine2;
	private int pin;
	
	public Address() {
	}
	
	public Address(String addLine1, String addLine2, int pin) {
		this.addLine1 = addLine1;
		this.addLine2 = addLine1;
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Address [addLine1=" + addLine1 + ", addLine2=" + addLine2 + ", pin=" + pin + "]";
	}
	
}