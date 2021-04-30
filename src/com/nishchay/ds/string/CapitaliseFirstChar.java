package com.nishchay.ds.string;


/*

 *	Input Format
 *
 *	The first line contains a string . The second line contains another string . The strings are comprised of only lowercase English letters.
 *
 *	Output Format
 *
 *	There are three lines of output:
 *	For the first line, sum the lengths of  and .
 *	For the second line, write Yes if  is lexicographically greater than  otherwise print No instead.
 *	For the third line, capitalize the first letter in both  and  and print them on a single line, separated by a space.
 *
 *	Sample Input:
 *
 *	hello
 *	java
 *
 *	Sample Output:
 *
 *	9
 *	No
 *	Hello Java
 * */
public class CapitaliseFirstChar {

    public static void main(String[] args) {
        String str1 = "good";
        String str2 = "morning";

        int len = str1.length() + str2.length();
        System.out.println(len);
        String compResult = str1.compareTo(str2) > 0 ? "Yes" : "No";
        System.out.println(compResult);

        // capitalize first letter
        String output1 = str1.substring(0, 1).toUpperCase() + str1.substring(1);
        String output2 = str2.substring(0, 1).toUpperCase() + str2.substring(1);

        System.out.println(output1 + " " + output2);
    }
}
