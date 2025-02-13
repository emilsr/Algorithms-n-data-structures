package main.f9;

public class SelectionSort {

    public static void sort(int[] array) {
        int maxIndex = 0;
        for (int j = 0; j < array.length-1; j++) {
            for (int i = j; i < array.length; i++) {
                if (array[i] < array[maxIndex]) {
                    maxIndex = i;
                }
            }
            int temp = array[j];
            array[j] = array[maxIndex];
            array[maxIndex] = temp;
        }
    }
}
