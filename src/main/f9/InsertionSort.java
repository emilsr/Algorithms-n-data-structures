package main.f9;

import java.util.Arrays;

public class InsertionSort {
    int a[] = new int[10];
    int length = 0;


    @Override
    public String toString() {
        return "InstickSortering{" +
                "a=" + Arrays.toString(a) +
                '}' +
                "length=" + length;
    }

    public boolean addSorted(int value){
        if(length == 0){
            a[length++] = value;
            return true;
        }
        for (int i = length; i > 0; i--) {
            if(a[i-1] > value){
                a[i] = a[i-1];
            } else {
                a[i]= value;
                length++;
                return true;
            }
        }
        a[0] = value;
        return true;
    }

    public static void main(String[] args) {
        InsertionSort sortering = new InsertionSort();

        System.out.println(sortering);
        System.out.println(sortering.addSorted(2));
        System.out.println(sortering);
        System.out.println(sortering.addSorted(70));
        System.out.println(sortering);
        System.out.println(sortering.addSorted(4));
        System.out.println(sortering);
        System.out.println(sortering.addSorted(2));
        System.out.println(sortering);
        System.out.println(sortering.addSorted(199));
        System.out.println(sortering);
    }
}
