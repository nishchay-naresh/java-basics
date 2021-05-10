package com.nishchay.core.basics;

interface Permission{	}

class MrkrInterfaceDemo implements Permission {
	private void show(){
		System.out.println("Hello");
	}

	public static void main(String[] args){

		MrkrInterfaceDemo obj = new MrkrInterfaceDemo();

		// Now we need to have some permission to execute the method show
		// Q - So how can we provide & later validate those permission 
		// A – Marker Interface
		if(obj instanceof Permission)
			obj.show();
		else
			System.out.println("No Permission !!");
	}
}
