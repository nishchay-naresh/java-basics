package com.nishchay.test.amex;

public class DayPlushNumber {

    public static void main(String[] args) {

        String day = "Wed"; int k = 45;
        System.out.printf(" %s + %d = %s%n", day, k , getDayPlushNumber(day, k));

        day = "Wed"; k = 4;
        System.out.printf(" %s + %d = %s%n", day, k , getDayPlushNumber(day, k));

        day = "Wed"; k = 5;
        System.out.printf(" %s + %d = %s%n", day, k , getDayPlushNumber(day, k));

    }

    private static String getDayPlushNumber(String day, int k) {
        String[] daysArray = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        int i = 0;
        for (; i < daysArray.length && !daysArray[i].equals(day); i++);
        int next = (i + k) % 7;

        return daysArray[next] ;
    }

}
