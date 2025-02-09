package main.f9;

import java.util.Arrays;

public class ShellSort {

    public static void sort(int[] arr) {
        int gap = arr.length / 2;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                var temp = arr[i];
                int dataIndex = i;
                while (dataIndex > gap-1 && temp < arr[dataIndex - gap]) {
                    arr[dataIndex] = arr[dataIndex - gap];
                    dataIndex -= gap;
                }
                arr[dataIndex] = temp;
            }
            if (gap == 2 ) { gap = 1;}
            else { gap = (int) (gap/2.2);}
        }
    }


    public static void main(String[] args) {
        int[] arr = { 7, 3, 1, 2, 5, 6 , 4, 10};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
