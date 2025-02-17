package main.f9;

import java.util.Random;


//import main.f10.nb31.HeapSort;
//import main.f10.nb31.HeapSort;

public class SortTest {
    public static void main(String[] args) {
        int arraySize = 1000;
        int iterations = 10000;

        long totalTimeInsertSort = 0;
        long totalTimeSelectionSort = 0;
        long totalTimeMergeSort = 0;
        long totalTimeShellSort = 0;
        long totalTimeQuickSort = 0;
        long totalTimeHeapSort = 0;

        Random r = new Random();


        for (int i = 0; i < iterations; i++) {
            int[] arrayInsertSort = new int[arraySize];
            int[] arraySelectionSort = new int[arraySize];
            int[] arrayMergeSort = new int[arraySize];
            int[] arrayShellSort = new int[arraySize];
            int[] arrayQuickSort = new int[arraySize];
            int[] arrayHeapSort = new int[arraySize];

            int t;

            for (int j = 0; j < arraySize; j++){
                t = r.nextInt(100);
                arrayInsertSort[j] = t;
                arraySelectionSort[j] = t;
                arrayMergeSort[j] = t;
                arrayShellSort[j] = t;
                arrayQuickSort[j] = t;
                arrayHeapSort[j] = t;

            }

            long startTime, endTime;

            startTime = System.nanoTime();
            SelectionSort.sort(arrayInsertSort);
            endTime = System.nanoTime();
            totalTimeInsertSort += endTime - startTime;

            startTime = System.nanoTime();
            SelectionSort.sort(arraySelectionSort);
            endTime = System.nanoTime();
            totalTimeSelectionSort += endTime - startTime;

            startTime = System.nanoTime();
            ShellSort.sort(arrayShellSort);
            endTime = System.nanoTime();
            totalTimeShellSort += endTime - startTime;

            startTime = System.nanoTime();
            MergeSort.sort(arrayMergeSort);
            endTime = System.nanoTime();
            totalTimeMergeSort += endTime - startTime;

            startTime = System.nanoTime();
            QuickSort.sort(arrayQuickSort);
            endTime = System.nanoTime();
            totalTimeQuickSort += endTime - startTime;


//            startTime = System.nanoTime();
//            HeapSort.sort(arrayHeapSort);
//            endTime = System.nanoTime();
//            totalTimeHeapSort += endTime - startTime;

        }
        System.out.println("Test was done with a Array size of " + arraySize + " and was ran: " + iterations + " times");

        System.out.println("Total time taken for InsertionSort......" + totalTimeInsertSort + " ns");
        System.out.println("Total time taken for SelectionSort......" + totalTimeSelectionSort + " ns");
        System.out.println("Total time taken for ShellSort.........." + totalTimeShellSort + " ns");
        System.out.println("Total time taken for MergeSort.........." + totalTimeMergeSort + " ns");
        System.out.println("Total time taken for QuickSort.........." + totalTimeQuickSort + " ns");
        System.out.println("Total time taken for heapSort..........." + totalTimeHeapSort + " ns \n");


        System.out.println("Avg time taken for InsertionSort......" + totalTimeInsertSort/iterations + " ns");
        System.out.println("Avg time taken for SelectionSort......" + totalTimeSelectionSort/iterations + " ns");
        System.out.println("Avg time taken for ShellSort.........." + totalTimeShellSort/iterations + " ns");
        System.out.println("Avg time taken for MergeSort.........." + totalTimeMergeSort/iterations + " ns");
        System.out.println("Avg time taken for QuickSort.........." + totalTimeQuickSort/iterations + " ns");
        System.out.println("Avg time taken for HeapSort..........." + totalTimeHeapSort/iterations + " ns \n");
    }
}
