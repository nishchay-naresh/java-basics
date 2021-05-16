package com.nishchay.ds.collection;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *	You are given a list of examination results of various students. A student can appear for examination multiple times.
 *	If a student appears for examination multiple times, calculate the result for that particular student will be the average of all the examinations.
 *	Return the student with the maximum result.
 *
 *	Input
 *	{
 *	{"Riya" "50"},
 *	{"Ramesh" "72"},
 *	{"Rinku" "65"},
 *	{"Riya" "100"}
 *	}
 *
 *	Output
 *	Riya
 *
 * */
public class MaxMarksWithAverageHM {

    public static void main(String[] args) {


        findMaxMarkWithOneReAttempt();
        findMaxMarkWithNReAttempt();

    }

    private static void findMaxMarkWithOneReAttempt() {

        String[] names = {"Riya", "Ramesh", "Rinku", "Riya", "Rishi"};
        int[] marks = {50, 72, 65, 100, 78};

        Map<String, Integer> marksHM = new HashMap<>();

        //  HashMap population
        int len = names.length;
        for (int i = 0; i < len; i++) {
            String currName = names[i];
            int currMarks = marks[i];
            Integer currMarksHM = marksHM.get(currName);
            currMarksHM = currMarksHM == null ? currMarks : (currMarks + currMarksHM) / 2;
            marksHM.put(currName, currMarksHM);
        }

        System.out.println("marksHM = " + marksHM);

        // finding max marks in HM
        int maxMarks = 0;
        String maxMarksName = "";
        for (Map.Entry<String, Integer> e : marksHM.entrySet()) {
            if(maxMarks < e.getValue()){
                maxMarks = e.getValue();
                maxMarksName  = e.getKey();
            }
        }

        System.out.println("Topper : " + maxMarksName + " : " +  maxMarks);
    }


    private static void findMaxMarkWithNReAttempt() {

        String[] names = {"Riya", "Ramesh", "Rinku", "Riya", "Rishi", "Riya", "Rishi"};
        int[] marks = {50, 72, 65, 70, 78, 90, 82};

        Map<String, List<Integer>> marksHM = new HashMap<>();


        //  HashMap population
        int len = names.length;
        for (int i = 0; i < len; i++) {
            String currName = names[i];
            int currMarks = marks[i];
            List<Integer> currMarksList = marksHM.get(currName);
            if(currMarksList == null){
                currMarksList = new ArrayList<>();
                marksHM.put(currName, currMarksList);
            }
            currMarksList.add(currMarks);
        }

        System.out.println("marksHM = " + marksHM);

        // finding max marks in HM
        int maxMarks = 0;
        String maxMarksName = "";
        for (Map.Entry<String, List<Integer>> e : marksHM.entrySet()) {
            Integer avgMarks = calculateAverage(e.getValue());
            if(maxMarks < avgMarks){
                maxMarks = avgMarks;
                maxMarksName  = e.getKey();
            }
        }

        System.out.println("Topper : " + maxMarksName + " : " +  maxMarks);

    }

    private static Integer calculateAverage(List <Integer> marks) {
        Integer avg = 0;
        if(!marks.isEmpty()) {
            for (Integer mark : marks) {
                avg += mark;
            }
            return avg / marks.size();
        }
        return avg;
    }

}
