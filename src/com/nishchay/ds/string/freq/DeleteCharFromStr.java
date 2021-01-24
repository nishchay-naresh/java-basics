package com.nishchay.ds.string.freq;

import java.util.stream.Collectors;

public class DeleteCharFromStr {

    public static void main(String[] args) {

        String str = "this is india, it is my country";
        String resStr = deleteCharStream(str, 'i');

        System.out.println("str = " + str);
        System.out.println("resStr = " + resStr);
    }


    private static String deleteCharStream(String str, char c) {

        return str.chars()
                .filter(e -> e != c)
                .mapToObj(e -> String.valueOf((char) e))
                .collect(Collectors.joining());

    }
}
