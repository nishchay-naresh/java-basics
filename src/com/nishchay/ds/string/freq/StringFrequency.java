package com.nishchay.ds.string.freq;

import java.util.HashMap;
import java.util.Map;

public class StringFrequency {

	public static void main(String[] args) {

		String[] strArray = "Nothing is as easy as it looks but it looks easy".split(" ");

		Map<String, Integer> feqMap = getFrequencyMap(strArray);
		System.out.println(feqMap);

		// HashMap - {but=1, as=2, looks=2, is=1, it=2, easy=2, Nothing=1}
		// LinkedHashMap - {Nothing=1, is=1, as=2, easy=2, it=2, looks=2, but=1}
	}


	public static Map<String, Integer> getFrequencyMap(String[] strArray) {

		Map<String, Integer> feqMap = new HashMap<>();
		Integer freq;
		for (String currStr : strArray) {
			freq = feqMap.get(currStr);
			freq = freq == null ? 1 : ++freq;
			feqMap.put(currStr, freq);
		}
		return feqMap;
	}
}
