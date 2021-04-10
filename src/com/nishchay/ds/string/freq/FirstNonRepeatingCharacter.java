package com.nishchay.ds.string.freq;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * char findFirst(String input)
 * Finds the first character that does not repeat anywhere in the input string
 * If all characters are repeated, return 0
 * Given "apple", the answer is "a"
 * Given "racecars", the answer is "e"
 * Given "ababdc", the answer is "d"
 * Given "simplest", the answer is "i"
 **/
public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {

        doTestsPass();

        System.out.println(" findFirstStream(\"java perl rep \") - " +  findFirstStream("java perl rep"));

    }

    /**
     * boolean doTestsPass()
     * Returns true if all tests pass. Otherwise returns false.
     */
    private static void doTestsPass() {
        // feel free to make testing more elegant
        String[] inputs = {"apple", "racecars", "ababdc", "simplest"};
        char[] outputs = {'a', 'e', 'd', 'i'};

        boolean result = true;
        for (int i = 0; i < inputs.length; i++) {
            result = result && findFirst(inputs[i]) == outputs[i];
            if (!result)
                System.out.println("Test failed for: " + inputs[i]);
            else
                System.out.println("Test passed for: " + inputs[i]);
        }
    }


    private static char findFirst(String input) {

        char firstChar = '0';
        char[] charArray = input.toCharArray();

        Map<Character, Integer> freqMap = new LinkedHashMap<>();

        Integer freq;
        for (char currChar : charArray) {
            freq = freqMap.get(currChar);
            freq = freq == null ? 1 : ++freq;
            freqMap.put(currChar, freq);
        }


        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                firstChar = entry.getKey();
                break;
            }
        }

//        System.out.println("input: " + input + "\t firstChar : " + firstChar);
        return firstChar;
    }


    // Finding first non repeating char in a string
    private static char findFirstStream(String input) {

        System.out.println("input = " + input);
        Map<Character, Long> freqMap = StringFrequencyUtility.getOrderedFrequencyMapStream(input);
        System.out.println("freqMap = " + freqMap);


        Character result = freqMap
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(entry -> entry.getKey())
                .findFirst().get();

        return result;
    }

}
