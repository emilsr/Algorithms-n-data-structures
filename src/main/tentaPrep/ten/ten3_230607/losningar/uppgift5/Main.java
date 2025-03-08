package main.tentaPrep.ten.ten3_230607.losningar.uppgift5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {1,14,8,21,4,13,7,5,3,33};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a) {
        if (a.length == 1) return;
        int[] b = Arrays.copyOfRange(a, 0, a.length / 2);
        sort(b);
        int[] c = Arrays.copyOfRange(a, a.length / 2, a.length);
        sort(c);
        merge(b, c, a);
    }

    static void merge(int[] a, int[] b, int[] c) {
        int indexa = 0, indexb = 0, indexc = 0;
        while (indexa < a.length && indexb < b.length) {
            if (a[indexa] <= b[indexb]) {
                c[indexc++] = a[indexa++];
            } else {
                c[indexc++] = b[indexb++];
            }
        }

        while (indexa < a.length) {
            c[indexc++] = a[indexa++];
        }

        while (indexb < b.length) {
            c[indexc++] = b[indexb++];
        }

    }
}