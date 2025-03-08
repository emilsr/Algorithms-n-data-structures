package main.tentaPrep.ten.ten3_230607.uppgift5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {1,14,8,21,4,13,7,5,3,33};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a) {
        if (a.length <= 1) return;
        int[] lower = Arrays.copyOfRange(a, 0, a.length/2);
        int[] upper = Arrays.copyOfRange(a, a.length/2+1, a.length);

        sort(lower);
        sort(upper);
        marge(lower, upper, a);
    }

    private static void marge(int[] lower, int[] upper, int[] newArray){
        int indexLower = 0; int indexUpper = 0; int indexNew = 0;

        while (indexLower<lower.length && indexUpper < upper.length){
            if (lower[indexLower] < upper[indexUpper]){
                newArray[indexNew] = lower[indexLower];
                indexLower++;
            } else {
                newArray[indexNew] = upper[indexUpper];
                indexUpper++;
            }
            indexNew++;
        }

        while (indexLower<lower.length){
            newArray[indexNew] = lower[indexLower];
            indexLower++;
            indexNew++;
        }
        while (indexUpper<upper.length){
            newArray[indexNew] = upper[indexUpper];
            indexUpper++;
            indexNew++;
        }
    }
}