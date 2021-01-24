package com.nishchay.core.basics.block;

class InstanceBlockVsConstructor {

	InstanceBlockVsConstructor() {
		System.out.println("Default Constructor called !"); 
	} 

	InstanceBlockVsConstructor(int  a){
		System.out.println("1-args Constructor called !"); 
	} 

	InstanceBlockVsConstructor(int a  , int b) {
		System.out.println("2-args Constructor called !"); 
	} 

	// Instance Initializer Block
	{ 
		System.out.println ("Instance Initializer Block called !"); 
	}

	public static void main (String args[]){ 
		new InstanceBlockVsConstructor(); // call default const
		new InstanceBlockVsConstructor(10); // call 1-args const
		new InstanceBlockVsConstructor(10,20); // call 2-args const
	}

}

/*
 *
 *	Output :-
 *
 *	Instance Initializer Block called !
 *	Default Constructor called !
 *	Instance Initializer Block called !
 *	1-args Constructor called !
 *	Instance Initializer Block called !
 *	2-args Constructor called !
 *
 *	if you observe output pattern , you might come to two conclusions :
 *
 *	1. Instance Initializer Block always invoke first then constructors.
 *	2. Constructor logic is specified to objects, whereas instance initializer block logic code is common for all objects.
 *	3. No matter , whatever constructor will be called by object , instance initializer block will be executed .*
 * */