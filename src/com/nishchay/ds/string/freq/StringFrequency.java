package com.nishchay.ds.string.freq;

import java.util.Map;

public class StringFrequency {

    public static void main(String[] args) {

        String input = "Nothing is as easy as it looks but it looks easy";
        String[] strArray = input.split(" ");

        System.out.println("input = " + input);

        Map<String, Integer> freqMap = StringFrequencyUtility.getFrequencyMap(strArray);
        System.out.println("Map<String, Integer> feqMap = " + freqMap);

        Map<String, Long> freqMap1 = StringFrequencyUtility.getFrequencyMapStream(strArray);
        System.out.println("Map<String, Long> freqMap1  =  " + freqMap1);

        Map<String, Long> orderedFreqMap = StringFrequencyUtility.getOrderedFrequencyMapStream(strArray);
        System.out.println("orderedFreqMap = \t" + orderedFreqMap);

    }

}

/*
 * O/P =>
 *	input = Nothing is as easy as it looks but it looks easy
 *	Map<String, Integer> feqMap = {but=1, as=2, looks=2, is=1, it=2, easy=2, Nothing=1}
 *	Map<String, Long> freqMap1  =  {but=1, looks=2, as=2, is=1, it=2, easy=2, Nothing=1}
 *	orderedFreqMap = 	{Nothing=1, is=1, as=2, easy=2, it=2, looks=2, but=1}
 * */