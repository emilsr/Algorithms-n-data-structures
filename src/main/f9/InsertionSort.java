package main.f9;

import java.util.Arrays;

public class InsertionSort {
    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j = j-1;
            }
            a[j + 1] = key;
        }
    }
}
