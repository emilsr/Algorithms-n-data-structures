package main.f10.nb31;

public class HeapSort {

    public static void sort(int[] array){
        int heapSize = 1;

        while (heapSize < array.length) {
            offer(array, heapSize++);
        }

        while (heapSize > 1) {
            array[heapSize - 1] = poll(array, heapSize - 1);
            heapSize--;
        }
    }

    private static void offer(int[] array, int index){
        shiftUp(array, index);
    }

    private static int poll(int[] array, int index){
        swap(0, index, array);
        shiftDown(array, 0, index);
        return array[index];
    }

    private static void shiftUp(int[] array, int index){
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (array[index] > array[parent]) {
                swap(index, parent, array);
                index = parent;
            } else {
                break;
            }
        }
    }

    private static void shiftDown(int[] array, int parent, int size) {
        while (true) {
            int chiledA = parent * 2 + 1;
            int chiledB = chiledA + 1;
            int largest = parent;
            
            if (chiledA < size && array[chiledA] > array[largest]) {
                largest = chiledA;
            }

            if (chiledB < size && array[chiledB] > array[largest]) {
                largest = chiledB;
            }

            if (largest == parent) return;

            swap(largest, parent, array);
            parent = largest;
        }
    }

    private static void swap(int a, int b, int[] array){
        int t = array[a];
        array[a] = array[b];
        array[b] = t;
    }
}
