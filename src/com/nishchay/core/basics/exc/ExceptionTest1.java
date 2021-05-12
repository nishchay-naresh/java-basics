package com.nishchay.core.basics.exc;

public class ExceptionTest1 {

    public static void main(String[] args) {
        validationForNumber(0);
        System.out.println("rest of the code ....");
    }

    private static void validationForNumber(int num){

        if(num <= 0){
           throw new ArithmeticException("Invalid number");
        }else{
            System.out.println("valid no, go ahead");
        }
    }
}
