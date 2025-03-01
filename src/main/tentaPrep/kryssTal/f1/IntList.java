package main.tentaPrep.kryssTal.f1;

/**
 * • IntList(int initialCapacity)
 * • add(int element)
 * • add(int index, int element)
 * • get(int index)
 * • indexOf(int element)
 * • remove(int index)
 * • set(int index, int element)
 * • size()
 */

public class IntList {
    int size;
    int maxSize;
    int[] data;

    public IntList(int initMaxSize){
        size=0;
        maxSize=initMaxSize;
        data = new int[maxSize];
    }

    public boolean add(int element){
        if (size == maxSize) reallocate();
        data[size++] = element;
        return true;
    }

    private void reallocate(){
        maxSize = maxSize*2;
        int[] t = new int [maxSize];
        for (int i = 0; i < size; i++){
            t[i] = data[i];
        }
        data=t;
    }


    public String toString()

    public static void main(String[] args) {
        IntList test = new IntList(10);
        for (int i = 0; i<15; i++){
            System.out.println(test.add(i));
        }
        System.out.println(test.toString());
    }


}
