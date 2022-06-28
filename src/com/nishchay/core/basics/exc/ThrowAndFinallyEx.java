package com.nishchay.core.basics.exc;

import java.io.FileReader;
import java.io.IOException;

public class ThrowAndFinallyEx {

    public static void main(String[] args) {
        validationForNumber(1);
        System.out.println("rest of the code ....");
        openFile();
    }

    // throw keyword example
    private static void validationForNumber(int num){
        if(num <= 0){
           throw new ArithmeticException("Invalid number");
        }else{
            System.out.println("valid no, go ahead");
        }


    }

    // finally keyword example
    public static void openFile(){
        FileReader reader = null;
        try {
            reader = new FileReader("data/data.txt");
            int i=0;
            while(i != -1){
                i = reader.read();
                System.out.println((char) i );
            }
        } catch (IOException e) {
            //do something clever with the exception
        } finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    //do something clever with the exception
                }
            }
            System.out.println("--- File End ---");
        }
    }

}
