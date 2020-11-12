package com.nishchay.ds.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringFrequency {

	public static void main(String[] args) {

		String[] data = "Nothing is as easy as it looks but it looks easy".split(" ");
		Map<String, Integer> feqMap = new LinkedHashMap<>();

		Integer freq = null;
		for (String key : data) {
			freq = feqMap.get(key);
			freq = freq == null ? 1 : ++freq;
			feqMap.put(key, freq);
		}
		System.out.println(feqMap);
		// {Nothing=1, is=1, as=2, easy=2, it=2, looks=2, but=1}
	}

}
