package com.nishchay.ds.string;

/*
* https://www.baeldung.com/java-string-contains-all-letters
* Check If a String Contains All The Letters of The Alphabet with Java
*   input - “Farmer jack realized that big yellow quilts were expensive.”
*   output - true Else false
*
* */
public class EnglishAlphabetLetters {

    public static void main(String[] args) {

        String sentence = "Farmer jack realized that big yellow quilts were expensive";
        System.out.println(checkStringForAllTheLetters(sentence));


        String string="The quick brown fox jumps over the lazy dog";
//        String string = "qwertyuioplkjhgfdsazxcvbnm";
        System.out.println(checkStringForAllLetterUsingStream(string));
    }

    // Imperative Algorithm
    public static boolean checkStringForAllTheLetters(String input) {
        int index = 0;
        boolean[] visited = new boolean[26];

        for (int i = 0; i < input.length(); i++) {
            if ('a' <= input.charAt(i) && input.charAt(i) <= 'z') {
                index = input.charAt(i) - 'a';
            } else if ('A' <= input.charAt(i) && input.charAt(i) <= 'Z') {
                index = input.charAt(i) - 'A';
            }
            visited[index] = true;
        }

        for (int i = 0; i < 26; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
    // Time Complexity -  O(n)


    // Java 8 Stream
    public static boolean checkStringForAllLetterUsingStream(String input) {
        long c = input.toLowerCase().chars()
                .filter(ch -> ch >= 'a' && ch <= 'z')
                .distinct()
                .count();
        return c == 26;
    }
    // Time Complexity -  O(n)

}
