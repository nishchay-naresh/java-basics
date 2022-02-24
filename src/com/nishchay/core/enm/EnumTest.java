package com.nishchay.core.enm;

public class EnumTest {


    public static void main(String[] args) {
        Days d1 = Days.SUN;
        String d1Name = d1.name();
        Days d2 = Days.valueOf(d1Name);

        String res = d1 == d2 ? "equal" : "unequal";
        System.out.println("d1 == d2 " + res);

        d1 = Days.SAT;
        d2 = Days.MON;
        // ordinal is like index
        System.out.printf("ordinal : %d = %d%n", d1.ordinal(), d2.ordinal());

        for (Days d : Days.values()) {
            System.out.println(d.name());
        }

    }

}

enum Days {
    MON,
    TUE,
    WED,
    THU,
    FRI,
    SAT,
    SUN
}
