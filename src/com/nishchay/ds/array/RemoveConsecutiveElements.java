package com.nishchay.ds.array;

/*
 * input intArr[] = {-4, -3, -2, -1, 0, 6, 7, 9, 11, 12, 13, 18, 20, 21, 22}
 * remove consecutive natural numbers from array
 * output
 *   String = -4 - 0, 6, 7, 9, 11 - 13, 18, 20-22
 *
 * */
public class RemoveConsecutiveElements {

    public static void main(String[] args) {
        int[] intArr = {-4, -3, -2, -1, 0, 6, 7, 9, 11, 12, 13, 18, 20, 21, 22};

        System.out.println("result = " + removeConsecutiveNumbers(intArr));
    }


    private static String removeConsecutiveNumbers(int[] num) {
        StringBuilder res = new StringBuilder();
        int length = num.length;

        for (int i = 0; i < length; i++) {

            // number sequence
            if (i + 2 < length && num[i] + 1 == num[i + 1] && num[i] + 2 == num[i + 2]) {
                res.append(num[i]).append(" - ");

                int j = i + 2;
                while (j + 1 < length && num[j] + 1 == num[j + 1]) {
                    j++;
                }
                res.append(num[j]).append(", ");
                i = j;
            } else if (i + 1 == length) {  // last element
                res.append(num[i]);
            } else { // single number
                res.append(num[i]).append(", ");
            }
        }
        return res.toString();
    }

}
