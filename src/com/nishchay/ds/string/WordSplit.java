package com.nishchay.ds.string;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/*
 *==============Coderbyte: "Word Split" Algorithm====================
 *
 * Have the function WordSplit(strArr) read the array off strings stored in strArr, which will contain 2 elements:
 * the first element will be a sequence of characters,
 * and the second element will be a long string of comma-seperated words, in alphabetical order, that represents a dictionary of some arbitrary length.
 *
 * For example: strArr can be: ["hellocat", "apple, bat,cat,goodbye,hello,yellow,why"].
 *
 * Your goal is to determine if the first element in the input can be split into two words, where both words in the dictionary that is provided in the second input.
 * In this example, the firs element can be split into two words: hello and cat because both of those words are in the dictionary.
 *
 * Your program should return the two words that exist in the dictionary seperated by a comma.
 * So for the example above, your program should return hello,cat.
 * There will only be one correcy way to split the first element of characters into two words.
 *  If there is no way to split string into two words that exist in the dictionary, return the string not possible.
 *  The first element itself will never exist in the dictionary as a real word.
 *
 * Examples -1
 * 		Input: new String[] {"baseball", "a,all,b,ball,bas,base,cat,code,d,e,quit,z"}
 * 		Output: base, ball
 *
 * Examples -2
 * 		Input: new String[] {"abcgefd", "a,ab,abc,abcg,b,c,dog,e,efd,zzzz"}
 * 		Output: abcg, efd
 *
 *Examples -3
 * 		Input: new String[] {"hellocat", "apple, bat,cat,goodbye,hello,yellow,why"}
 * 		Output: hello, cat
 *Examples -4
 * 		Input: new String[] {"helloworld", "h,he,hell,hello,w,word,wild,mate,quit,z, friend"}
 * 		Output: Not Possible
 * */
public class WordSplit {

    public static void main(String[] args) {

        String[] input =  new String[] {"baseball", "a,all,b,ball,bas,base,cat,code,d,e,quit,z"};
        System.out.println("Output - " + findOnlyPair(input)); // base, ball

        input =  new String[] {"abcgefd", "a,ab,abc,abcg,b,c,dog,e,efd,zzzz"};
        System.out.println("Output - " + findOnlyPair(input)); // abcg, efd

        input =  new String[] {"hellocat", "apple, bat,cat,goodbye,hello,yellow,why"};
        System.out.println("Output - " + findOnlyPair(input)); // hello, cat

        input =  new String[] {"helloworld", "h,he,hell,hello,w,word,wild,mate,quit,z, friend"};
        System.out.println("Output - " + findOnlyPair(input)); // Not Possible

    }

    /*
     * Time complexity - O(n)
     * Space complexity - O(n)
    * */
    private static String findOnlyPair(String[] strArr) {

        // First Element - wordToCompare
        String wordToCompare = strArr[0];
        int length = wordToCompare.length();
        // Second Element - words separated by ,
        String stringDictionary = strArr[1];

        // words separated by , -> Array of strings -> Set<String>
        Set<String> dictionary = Arrays.stream(stringDictionary.split(",")).collect(Collectors.toSet());

        // Hold Answers
        String leftPart, rightPart;
        for (int i = 1; i < length; i++) {
            leftPart = wordToCompare.substring(0,i);
            rightPart = wordToCompare.substring(i,length);
            if(dictionary.contains(leftPart) && dictionary.contains(rightPart)){
                return leftPart + ", " + rightPart;
            }
        }
        return "Not Possible";
    }


}
