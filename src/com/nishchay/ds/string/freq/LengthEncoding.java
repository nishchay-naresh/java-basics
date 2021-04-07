package com.nishchay.ds.string.freq;

/*
 *Input is a string like "AAAAABBCCAA" and it should print "5A2B2C2A".
 * 5 being the continuous number of occurance for character 'A'
 *
 * input -  “wwwwaaadexxxxxxywww”
 * output - “4w3a1d1e6x1y3w”
 *
 * */
public class LengthEncoding {

    public static void main(String[] args) {

        System.out.println("getLengthEncodedString(\"wwwwaaadexxxxxxywww\") - " + getLengthEncodedString("wwwwaaadexxxxxxywww"));
        System.out.println("getLengthEncodedString(\"AAAAABBCCAA\") - " + getLengthEncodedString("AAAAABBCCAA"));

    }

    private static String getLengthEncodedString(String str) {
        StringBuilder res = new StringBuilder();
        int n = str.length();
        for (int i = 0; i < n; i++) {

            // Count occurrences of current character
            int count = 1;
            while (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }

            res.append(count).append(str.charAt(i));
        }
        return res.toString();
    }

}

/*
 * o/p =>
 * getLengthEncodedString("wwwwaaadexxxxxxywww") - 4w3a1d1e6x1y3w
 * getLengthEncodedString("AAAAABBCCAA") - 5A2B2C2A
 * */
