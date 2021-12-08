package com.nishchay.core.enm;

public class EnumTest {


    public static void main(String[] args) {
            Days d1 = Days.SUN;
        String d1Name = d1.name();
        Days d2 = Days.valueOf(d1Name);

        String res = d1 == d2?"equal":"unequal";
        System.out.println("d1 == d2 " + res);

        for(Days d : Days.values()){
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
