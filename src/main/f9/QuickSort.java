package main.f9;

import java.util.Arrays;

public class QuickSort {
    public int [] array;

    public int[] sort(int[] array) {
        this.array = array;
        quickSort(0, array.length-1);
        return array;
    }

    public void quickSort(int from , int to) {
        if (from >= to) { return; }
        int pointer = from;

        for (int i = from; i < to; i++) {
            if (array[i] < array[to]) {
                swap(pointer, i);
                pointer++;
            }
        }
        swap(pointer, to);

        quickSort(from, pointer-1);
        quickSort(pointer+1, to);

    }

    private void swap(int from, int to) {
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{7,8,2,6,1,3,5};
        QuickSort qs = new QuickSort();
        System.out.println(Arrays.toString(a));
        System.out.println("Pivot: " + a[a.length - 1]);
        System.out.println(Arrays.toString(qs.sort(a)));
    }
}
