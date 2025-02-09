package main.f9;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    int a[];
    int size;

    public SelectionSort() {
        this.a = new int[10];
        this.size = 0;
    }

    public void initMocValue() {
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            a[i] = r.nextInt(100);
            size++;
        }
    }

    public void sort() {
        int maxIndex = 0;
        for (int j = 0; j < size-1; j++) {
            for (int i = j; i < size; i++) {
                if (a[i] < a[maxIndex]) {
                    maxIndex = i;
                }
            }
            int temp = a[j];
            a[j] = a[maxIndex];
            a[maxIndex] = temp;
            System.out.println(Arrays.toString(a));
        }

    }

    public String toSting() {
        String str = "";
        for (int i = 0; i < 5; i++) {
            str += a[i] + " ";
        }
        return str;
    }


    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        sort.initMocValue();
        System.out.println(sort.toSting());
        sort.sort();
        System.out.println(sort.toSting());
    }
}
