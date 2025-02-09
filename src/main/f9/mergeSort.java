package main.f9;

import java.util.Arrays;

public class mergeSort {

    public static void sort(int[] arr) {
        if (arr.length <= 1) {return;}
        int[] lower = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] upper = Arrays.copyOfRange(arr, arr.length / 2, arr.length);

        sort(lower);
        sort(upper);
        merge(lower, upper, arr);
    }

    private static void merge(int[] lower, int[] upper, int[] c) {
        int indexLower = 0, indexUpper = 0, indexC = 0;

        while (indexLower < lower.length && indexUpper < upper.length){
            if (lower[indexLower] <= upper[indexUpper]) {
                c[indexC++] = lower[indexLower++];
            } else {
                c[indexC++] = upper[indexUpper++];
            }
        }
        // If "lower" is longer then "upper"
        while (indexLower < lower.length) {
            c[indexC++] = lower[indexLower++];
        }
        // If "upper" is longer then "lower"
        while (indexUpper < upper.length) {
            c[indexC++] = upper[indexUpper++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 8, 5, 3, 7};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
