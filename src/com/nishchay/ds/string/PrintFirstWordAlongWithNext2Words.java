package com.nishchay.ds.string;

public class PrintFirstWordAlongWithNext2Words {

    public static void main(String[] args) {

        String line = "1 Alok DK Naiyyar Yogi Sharma Akhilesh Shankar";

        String result = getResultString(line);

        System.out.println("Result - " + result);
    }

    private static String getResultString(String line) {
        String[] strArray = line.split(" ");
        String lineNo = strArray[0];
        StringBuilder res = new StringBuilder();
        for (int i=1; i< strArray.length; i = i + 2) {
            res.append(lineNo);
            res.append(strArray[i]);
            if(i + 1 < strArray.length){
                res.append(strArray[i+1]);
            }
            res.append("\t");
        }
        return res.toString();
    }
}
