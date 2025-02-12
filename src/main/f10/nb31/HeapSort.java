package main.f10.nb31;

public class HeapSort {

    public static void sort(int[] array){
        int heapSiez = 0;

        while (heapSiez<array.length) {
            offer(array, heapSiezze++);
        }
        while (heapSiez > 1) {
            array[heapSiez-1] = poll(array, heapSiez);
        }
    }

    private void offer(int[] array, int index){
        
        
    }
}
