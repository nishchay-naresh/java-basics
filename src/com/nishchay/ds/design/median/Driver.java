package com.nishchay.ds.design.median;

public class Driver {

    public static void main(String[] args) {
        m2();
    }


    private static void m2() {
        MedianOfIntegerStream ref = new MedianOfIntegerStream();
        ref.add(5);
        double median = ref.getMedian();
        System.out.println("Median : " + median); //5.0

        ref.add(8);
        median = ref.getMedian();
        System.out.println("Median : " + median); //6.5

        ref.add(1);
        median = ref.getMedian();
        System.out.println("Median : " + median); //5.0

        ref.add(4);
        median = ref.getMedian();
        System.out.println("Median : " + median); //4.5

        ref.add(2);
        median = ref.getMedian();
        System.out.println("Median : " + median); //4.0

        ref.add(8);
        median = ref.getMedian();
        System.out.println("Median : " + median); //4.5

        ref.add(5);
        median = ref.getMedian();
        System.out.println("Median : " + median); //5.0

        ref.add(5);
        median = ref.getMedian();
        System.out.println("Median : " + median); //5.0
    }
}
/*
 * O/P =>
 *	Median :5.0
 *	Median :6.5
 *	Median :5.0
 *	Median :4.5
 *	Median :4.0
 *	Median :4.5
 *	Median :5.0
 *	Median :5.0
 * */