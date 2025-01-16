package main.F2;

import java.util.Arrays;

/**
 * Create a class called IntList that implements a list specifically for storing integers using an array.
 * The class should not use any Java Collection Framework (JCF) classes.
 * <p>
 *     Needed methods
 *     IntList(int initialCapacity)
 *     add(int element)
 *     add(int index, int element)
 *     get(int index)
 *     indexOf(int element)
 *     remove(int index)
 *     set(int index, int element)
 *     size()
 * </p>
 */

public class IntList {
    int[] list;
    int currentSize;
    int maxSize;

    IntList(int initialCapacity){
        this.list = new int[initialCapacity];
        this.currentSize = 0;
        this.maxSize = initialCapacity;

    }
    public boolean add(int element) {
        if (currentSize == maxSize){
            return false;   //fix relocate
        }
        list[currentSize++] = element;
        return true;
    }

    public boolean add(int element, int index) {
        if (currentSize == maxSize-1){
            return false;   //fix relocate
        }
        if (index > 0 || index > currentSize){
            throw new IndexOutOfBoundsException();
        }
        for (int i = currentSize-1; i > index; i--){
            list[i] = list[i+1];
        }
        list[index] = element;
        return true;
    }

    public int get(int index) {
        return 0;
    }

    public int indexOf(int element) {
        return 0;
    }

    public boolean remove(int index){
        return true;
    }

    public void set(int index, int element) {

    }

    public int size() {
        return 0;
    }

    @Override
    public String toString() {
        return "IntList{" +
                "list=" + Arrays.toString(list) +
                ", currentSize=" + currentSize +
                ", maxSize=" + maxSize +
                '}';
    }
}
