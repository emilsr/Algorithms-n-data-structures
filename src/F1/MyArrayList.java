package F1;
import java.sql.SQLOutput;
import java.util.Arrays;

/**
 *  * Make a ArrayList Class
 *  *** Requirements ***
 *  boolean add
 *  boolean remove(index)
 *  boolean remove(element)
 *  "maxSize"*2  if "nrOfElements" == "maxSize"
 *  boolean contains
 *
 *
 *  Needed Methods
 *  -- boolean add(E e)     #Done
 *  ----Add element to list return true if successful
 *  -- void add(int index, E e)     #Done
 *  ---- Add element to list at index, move all elements with the same or higher index to the right one step
 *  -- E get(int index)
 *  ---- Return element in list at index
 *  -- int indexOf(Object o)
 *  ---- return index of an element
 *  -- E remove(int index)      #Works, need clean up
 *  ---- remove object at index, move all object with a higher index to the left one step
 *  -- E set(int index, E element)
 *  ---- replace an object at index with new element
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
            if (nrOfElements >= maxSize) {
                return false;   // make data lager
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

    public E get(int index) {
        if (index < 0 || index >= nrOfElements) {
            System.out.println("Index out of bounds");
            return null;
        }
        return data[index];
    }

    public void remove(int index) {
        System.out.println("index is " + index+ " nrOfElements " + nrOfElements);
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

    public boolean contains(E element) {    //maybe return index instead?
        for (int i = 0; i <= nrOfElements; i++) {
            if (data[i] == element) {
                return true;
            }
        }
        return false;
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

        System.out.println(testList.add(1));
        System.out.println(testList.add(2));
        System.out.println(testList.add(3));
        System.out.println(testList.toString());
        testList.remove(1);
        testList.remove(2);    // should fail
        System.out.println(testList.toString());
        testList.add(0, 8);
        testList.add(10, 8);
        System.out.println(testList.toString());
        System.out.println(testList.get(0));
        System.out.println(testList.get(10));
    }
}
