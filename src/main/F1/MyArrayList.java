package main.F1;
import java.util.Arrays;

/**
 *  Needed Methods
 *  -- boolean add(E e)     #Done
 *  ----Add element to list return true if successful
 *  -- void add(int index, E e)     #Done
 *  ---- Add element to list at index, move all elements with the same or higher index to the right one step
 *  -- E get(int index)     #Done
 *  ---- Return element in list at index
 *  -- int indexOf(Object o)    #Done
 *  ---- return index of an element
 *  -- E remove(int index)      #Done
 *  ---- remove object at index, move all object with a higher index to the left one step
 *  -- E set(int index, E element)      #Done
 *  ---- replace an object at index with new element
 *
 *  ToDo add better error handling.
 *  ToDo add unit test.
 */


public class MyArrayList<E> {

    private E[] data;
    private int nrOfElements;
    private int maxSize;

    public MyArrayList() {
        nrOfElements = 0;
        maxSize = 10;
        data = (E[]) new Object[maxSize];
    }

    public boolean add(E element) {
        if (element != null) {
            if (nrOfElements == maxSize) {
                increaseSize();
            }
            data[nrOfElements] = element;
            nrOfElements++;
            return true;
        }
        System.out.println("Element is null");
        return false;
    }

    public void add(int index, E element) {
        if (index < 0 || index >= nrOfElements) {
            System.out.println("Index out of bounds");
            return;
        }
        for (int i = nrOfElements; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        nrOfElements++;
    }

    private void increaseSize() {
        maxSize *= 2;
        E[] temp = (E[]) new Object[maxSize];
        for (int i = 0; i < nrOfElements; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public E get(int index) {
        if (index < 0 || index >= nrOfElements) {
            System.out.println("Index out of bounds");
            return null;
        }
        return data[index];
    }

    public void remove(int index) {
        if (index>=nrOfElements){
            System.out.println("Index: " + index + " dose not exist in list");
        }
        if (index < nrOfElements) {
            for (int i = index; i <= nrOfElements; i++) {
                data[i] = data[i+1];
            }
            nrOfElements--;
        }
    }

    public E set(int index, E element) {
        if (index < 0 || index >= nrOfElements) {
            System.out.println("Index out of bounds");
            return null;
        }
        E temp = data[index];
        data[index] = element;
        return temp;

    }

    public int indexOf(E element) {
        for (int i = 0; i < nrOfElements; i++) {
            if (data[i] == element) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "data=" + Arrays.toString(data) +
                ", nrOfElements=" + nrOfElements +
                ", maxSize=" + maxSize +
                '}';
    }

    public static void main(String[] args) {
        MyArrayList<Object> testList = new MyArrayList<>();

        testList.add(1);
        testList.add(2);
        testList.remove(0);
        System.out.println(testList);
        testList.remove(0);
        System.out.println(testList);
        for (int i = 0; i < 15; i++) {
            testList.add(i);
        }
        System.out.println(testList);
    }
}
