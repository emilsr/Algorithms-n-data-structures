package main.f9;

public class QuickSort {

    public static void sort(int[] array) {
        quickSort(array ,0, array.length-1);
    }

    private static void quickSort(int[] array ,int from, int to) {
        if (from >= to) { return; }
        int pointer = from;

        for (int i = from; i < to; i++) {
            if (array[i] < array[to]) {
                swap(array, pointer, i);
                pointer++;
            }
        }
        swap(array, pointer, to);
        quickSort(array, from, pointer-1);
        quickSort(array,pointer+1, to);
    }

    private static void swap(int[] array, int from, int to) {
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }
}
