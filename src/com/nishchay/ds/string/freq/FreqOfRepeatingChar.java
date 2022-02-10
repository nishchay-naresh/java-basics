package com.nishchay.ds.string.freq;

import java.util.Map;

/*
 *	=========== Freq Of Repeating Chars ===========
 *
 *	Write a code to find the duplicate occurrences of char in the string.
 *	Example 1:
 *		String a = "abbcdddebbddccceeff";
 *		Answer: 13
 *	        	a, bbbb, cccc, ddddd, eee, ff
 *	        	0   3      3    4      2   1 = 13
 *
 * ------------------------------------------
 *
 *	Write an efficient program to print all the duplicates and their counts in the input string
 *
 *	Example 1:
 *		String str = "test string";
 *		Answer: 13
 *	        	s=2, t=3 , 1+2 = 3
 *
 * https://www.geeksforgeeks.org/print-all-the-duplicates-in-the-input-string/
 *
 * */
public class FreqOfRepeatingChar {

    public static void main(String[] args) {
        String str;

        str = "The quick brown fox jumped over the lazy dog";
        System.out.printf("%s has repeatingCharCount - %d%n", str, getRepeatingCharCount(str)); //17

        str = "abbcdddebbddccceeff";
        System.out.printf("%s has repeatingCharCount - %d%n", str, getRepeatingCharCount(str)); //9

        str = "test string";
        System.out.printf("%s has repeatingCharCount - %d%n", str, getRepeatingCharCount(str)); //3
    }


    private static int getRepeatingCharCount(String s) {

        Map<Character,Integer> freqMap = StringFrequencyUtility.getFrequencyMap(s);

        int count = 0;
        int currCharFreq;
        for (Map.Entry<Character,Integer> e : freqMap.entrySet()) {
            currCharFreq = e.getValue();
            if( currCharFreq > 1){
                count = count + (currCharFreq - 1);
            }
        }
        return count;
    }

}
