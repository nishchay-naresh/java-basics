package com.nishchay.ds.number;

/*
 *	input a number (10 <= number <= 1000), Apply below logic repeatedly , until number is not covert to 1
 *		If number is Even - divide by two
 *		If number is Odd - multiply by 3 and add 1
 *	Need to tell how many operation step would require to covert the number to 1
 *
 * ------------------------------------------
 *
 *	Print below series :
 *	1
 *	2 3
 *	4 5 6
 *	7 8 9 10
 *
 * */
public class ConvertNumToOne {

    public static void main(String[] args) {


        convertNo(70);
        convertNo(850);
        convertNo(79);

        System.out.println(" -------------------------------------- ");

        printPyramid(5);
        printPyramid(8);

    }


    private static void convertNo(int n) {

        int opCount = 0;
        while (n > 10 && n < 1000) {
            if (n % 2 == 0)
                n = n / 2 ;
            else
                n = n * 3 + 1;
            opCount++;
        }
        System.out.println("operationStepCount - " + opCount);
    }

    private static void printPyramid(int LineNo) {
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
