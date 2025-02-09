package main.f9;

import java.util.Arrays;

public class ShellSort {

    public static void ShellSort(int[] arr) {
        int n = arr.length;
        int gap = n / 2;
        while (gap > 0) {
            for (int i = 0; i + gap < arr.length; i++) {
                if (arr[i] > arr[i + gap]) {
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                }
            }
            System.out.println("G " + gap + ": " + Arrays.toString(arr));
            gap--;
        }
    }


    public static void main(String[] args) {
        int[] arr = { 3, 7, 10, 1, 5, 4, 11, 6 };
        ShellSort(arr);
    }
}
