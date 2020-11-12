package com.nishchay.ds.number;

public class ConvertNumToOne {

    public static void main(String[] args) {


        convertNo(70);
        convertNo(850);
        convertNo(79);

//        printPyramid(5);
    }


    public static void  convertNo(int n) {

        int stepCount = 0;
        while (n > 10 && n < 10000) {
            if (n % 2 == 0)
                evenNoLogic(n);
            else
                oddNoLogic(n);
            stepCount++;
        }
        System.out.print("stepCount - " + stepCount);
    }

    public static int evenNoLogic(int n) {
        return n / 2;
    }

    public static int oddNoLogic(int n) {
        return n * 3 + 1;
    }


    public static void printPyramid(int LineNo) {
        int n = 1;
        for (int i = 1; i <= LineNo; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(n + " ");
                n++;
            }
            System.out.print("\n");
        }
    }

}
