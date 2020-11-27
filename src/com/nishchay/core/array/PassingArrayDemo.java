package com.nishchay.core.array;

import java.util.Arrays;

public class PassingArrayDemo {

	public static void main(String[] args) {
		
		String[] names = new String[5];

		populateArray(names);
		sortArray(names);
		printArray(names);

	}

	public static void populateArray(String[] strArr) {
		strArr[0] = "raj";
		strArr[1] = "rajesh";
		strArr[2] = "rajeshwari";
		strArr[3] = "rajdhani";
		strArr[4] = "rajani";
	}

	public static void sortArray(String[] strArr) {
		Arrays.sort(strArr);
	}

	public static void printArray(String[] strArr) {
		System.out.println("strArr = " + Arrays.toString(strArr));
		for (String s : strArr)
			System.out.println(s);
	}

}
