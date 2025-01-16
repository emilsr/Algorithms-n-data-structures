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
            relocate();
        }
        list[currentSize++] = element;
        return true;
    }

    public boolean add(int element, int index) {
        if (currentSize == maxSize){
            relocate();
        }
        indexCheck(index);
        for (int i = currentSize-1; i > index; i--){
            list[i+1] = list[i];
        }
        list[index] = element;
        currentSize++;
        return true;
    }

    public int get(int index) {
        indexCheck(index);
        return list[index];
    }

    public int indexOf(int element) {
        for (int i = 0; i < currentSize; i++) {
            if (list[i] == element){
                return i;
            }
        }
        return -1;
    }

    public void remove(int index){
        indexCheck(index);
        for (int i = index; i < currentSize-1; i++) {
            list[i] = list[i + 1];
        }
        currentSize--;
    }

    public void set(int index, int element) {
        indexCheck(index);
        list[index] = element;
    }

    public int size() {
        return currentSize;
    }

    private void indexCheck(int index){
        if (index < 0 || index > currentSize){
            throw new IndexOutOfBoundsException();
        }
    }

    private void relocate(){
        int[] temp = new int[2 * maxSize];
        for (int i = 0; i < currentSize; i++) {
            temp[i] = list[i];
        }
        list = temp;
        maxSize = maxSize * 2;
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
