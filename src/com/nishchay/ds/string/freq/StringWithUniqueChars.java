package com.nishchay.ds.string.freq;

import java.util.HashSet;
import java.util.Set;

public class StringWithUniqueChars {


	public static void main(String[] args) {

		System.out.println("isUniqueCharsOnlyHashSet(\"\"adiction\"\") - " + isUniqueCharsOnlyHashSet("adiction"));
		System.out.println("isUniqueCharsOnlyHashSet(\"\"abcdefirtup\"\") - " + isUniqueCharsOnlyHashSet("abcdefirtup"));

		System.out.println("isUniqueCharsOnlyStream(\"\"adiction\"\") - " + isUniqueCharsOnlyStream("adiction"));
		System.out.println("isUniqueCharsOnlyStream(\"\"abcdefirtup\"\") - " + isUniqueCharsOnlyStream("abcdefirtup"));

	}

	public static boolean isUniqueCharsOnlyHashSet(String str){

		Set<Character> hashSet = new HashSet<>();

		for(char c : str.toCharArray()){ //iterate through character array
			if(!hashSet.add(c))//try to add each char to hashSet
				return false; //return false if could not add
		}
		return true;
	}


	public static boolean isUniqueCharsOnlyStream(String str){
		return str.length() == str.chars().distinct().count();
	}
}
