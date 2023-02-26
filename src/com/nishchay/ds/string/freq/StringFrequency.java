package com.nishchay.ds.string.freq;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringFrequency {

    public static void main(String[] args) {

        stringFrequencyEx();
        getFrequencyOfAWordEx();
        nMostFrequentStringEx();

    }

    private static void stringFrequencyEx() {

        String input = "Nothing is as easy as it looks but it looks easy";
        String[] strArray = input.split(" ");

        System.out.println("input = " + input);

        Map<String, Integer> freqMap = StringFrequencyUtility.getFrequencyMap(strArray);
        System.out.println("simple feqMap = " + freqMap);

        freqMap = StringFrequencyUtility.getFrequencyMapStream_intCount(strArray);
        System.out.println("ordered feqMap = " + freqMap);

        Map<String, Long> freqMap1 = StringFrequencyUtility.getFrequencyMapStream(strArray);
        System.out.println("Map<String, Long> freqMap1  =  " + freqMap1);

        Map<String, Long> orderedFreqMap = StringFrequencyUtility.getOrderedFrequencyMapStream(strArray);
        System.out.println("orderedFreqMap = \t" + orderedFreqMap);


    }

    /*
     * A string sentence is comma separated find the frequency of the given word in the string.
     *
     * */
    private static void getFrequencyOfAWordEx() {

        String mainStr = "car, bus, car, jeep, cycle, bike, train, bus, truck, jeep, car, jeep, cycle, truck, train, car, bike, bus, cycle";
        String word = "car";

        Map<String, Long> freqMap = StringFrequencyUtility.getFrequencyMapStream(mainStr.split(", "));
        System.out.println("freqMap  =  " + freqMap);

        System.out.println("Frequency Of Word : " + word + " -> " + freqMap.get(word));

    }

    /*
     * freqMap  =  {car=4, bus=3, jeep=3, cycle=3, bike=2, train=2, truck=1}
     *
     * most frequent word
     * n=1, car
     * n=2, bus
     * n=3, bike
     * n=4, truck
     *
     *  if there are multiple words with same freq, then consider the first one
     * listOfKeys = [car, bus, jeep, cycle, bike, train, truck]
     *
     * */
    private static void nMostFrequentStringEx() {

        String mainStr = "car, bus, car, jeep, cycle, bike, train, bus, truck, jeep, car, jeep, cycle, train, car, bike, bus, cycle";
        int n = 3;

        Map<String, Long> freqMap = StringFrequencyUtility.getOrderedFrequencyMapStream(mainStr.split(", "));
        System.out.println("freqMap  =  " + freqMap);

        if (freqMap.size() < n) {
            throw new IllegalArgumentException("Not enough different string.");
        }

        List<Map.Entry<String, Long>> freqMapStrKey = freqMap.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .collect(Collectors.toList());
        System.out.println("freqMapStrKey = " + freqMapStrKey);

        Map<Long, String> freqMapIntKey = new HashMap<>(freqMapStrKey.size());
        for (Map.Entry<String, Long> entry : freqMapStrKey) {
            if (!freqMapIntKey.containsKey(entry.getValue())) {
                freqMapIntKey.put(entry.getValue(), entry.getKey());
            }
        }

        List<String> stringListFreqRev = freqMapIntKey.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey, Comparator.reverseOrder()))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        System.out.println("stringListFreqRev = " + stringListFreqRev);

        System.out.println("nthFreqStr = " + stringListFreqRev.get(n - 1));
    }

    private static String nMostFrequentString(String input, int n) {
        return null;
    }
}

/*
 * O/P =>
 *	input = Nothing is as easy as it looks but it looks easy
 *	Map<String, Integer> feqMap = {but=1, as=2, looks=2, is=1, it=2, easy=2, Nothing=1}
 *	Map<String, Long> freqMap1  =  {but=1, looks=2, as=2, is=1, it=2, easy=2, Nothing=1}
 *	orderedFreqMap = 	{Nothing=1, is=1, as=2, easy=2, it=2, looks=2, but=1}
 * */