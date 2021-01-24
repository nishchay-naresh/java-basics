package com.nishchay.ds.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 *	Two strings are isomorphic if one-to-one mapping is possible for
 *	every character of the first string to every character of the second string.
 *	For example, consider the two strings: “ACAB” and “XCXY”.
 *
 *	Input:  str1 = "aab", str2 = "xxy"
 *	Output: True
 *	'a' is mapped to 'x' and 'b' is mapped to 'y'.
 *
 *	Input:  str1 = "aab", str2 = "xyz"
 *	Output: False
 *
 * */
public class IsomorphicString {

    public static void main(String[] args) {

        System.out.println("isIsomorphic(\"watch\", \"solid\") - " + isIsomorphic("watch", "solid"));
        System.out.println("isIsomorphic(\"turtle\", \"tletur\") - " + isIsomorphic("turtle", "tletur"));
        System.out.println("isIsomorphic(\"paper\", \"title\") - " + isIsomorphic("paper", "title"));
        System.out.println("isIsomorphic(\"egg\", \"add\") - " + isIsomorphic("egg", "add"));

        System.out.println("isIsomorphic(\"foo\", \"bar\") - " + isIsomorphic("foo", "bar"));
        System.out.println("isIsomorphic(\"ofo\" , \"app\") - " + isIsomorphic("ofo", "app"));

    }

	/*
	 *
	 *	1) If lengths of str1 and str2 are not same, return false.
	 *	2) Do following for every character in str1 and str2
	 *	   a) If this character is seen first time in str1,
	 *	      (i) If current character of str2 is seen, return false
	 *	      (ii)Else Do a mapping between current character str1 & str2
	 *			   Mark current character of str2 as visited.
	 *	   b) Else check if previous occurrence of str1[i] mapped to same character.
	 * */
    public static boolean isIsomorphic(String str1, String str2) {
        // Two strings cannot be isomorphic if they have different lengths.
        if (str1.length() != str2.length()) {
            return false;
        }

        // Use Java's built in map to store mappings of str1 chars to str2 chars.
        Map<Character, Character> map = new HashMap<>();

        // Use a set to keep track of already mapped characters.
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i), c2 = str2.charAt(i);

            // If c1 has been encountered before:
            if (map.containsKey(c1)) {
                // Return false if first occurrence of c1 is mapped to
                // a different character.
                if (map.get(c1) != c2)
                    return false;
            }
            // If c1 is encountered for the first time, it has not been mapped yet:
            else {
                // Return false if c2 is already mapped to some other char in str1
                if (set.contains(c2))
                    return false;

                // All checks passed. So insert in the map, and the set.
                map.put(c1, c2);
                set.add(c2);
            }
        }
        return true;
    }
//	Time complexity of this solution is O(n*n)

}
