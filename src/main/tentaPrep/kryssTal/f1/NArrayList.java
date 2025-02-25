package main.tentaPrep.kryssTal.f1;

/**
 *  Needed Methods
 *  -- boolean add(E e)
 *  ----Add element to list return true if successful   (done)
 *  -- void add(int index, E e)     (done)
 *  ---- Add element to list at index, move all elements with the same or higher index to the right one step
 *  -- E get(int index)     (done)
 *  ---- Return element in list at index
 *  -- int indexOf(Object o)    (done)
 *  ---- return index of an element
 *  -- E remove(int index)
 *  ---- remove object at index, move all object with a higher index to the left. return the element.
 *  -- E set(int index, E element)
 *  ---- replace an object at index with new element
 *  -- String toString()    (Done)
 *
 *  Test all edge cases and make sure it's type safe.
 */

public class NArrayList<E> {
    private E[] elements;
    private int size;
    private int maxSize;

    public NArrayList() {
        size = 0;
        maxSize = 10;
        elements = (E[]) new Object[maxSize];
    }

    public boolean add(E element){
        if (size == maxSize)
            reallocate();
        if (element == null)
            throw new IllegalArgumentException("Element can't be null");
        elements[size++] = element;
        return true;
    }

    public void add(E element, int index){
        if (0 > index && index >= maxSize) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        if (size == maxSize) {
            reallocate();
        }
        System.out.println("size: " + size);
        for (int i = size; i>index; i--){
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    }

    public E get(int index) {
        if (0 < index && index >= size)
            throw new IndexOutOfBoundsException();
        return elements[index];
    }

    public int indexOf(E element){
        for (int i = 0; i < size; i++){
            if (element.equals(elements[i])){
                return i;
            }
        }
        return -1;
    }

    private void reallocate(){
        maxSize = 2 * maxSize;
        E[] t = (E[]) new Object[maxSize];
        for (int i=0; i < size; i++){
            t[i] = elements[i];
        }
        elements = t;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("size:").append(size).append(" maxSize:").append(maxSize).append(" [");
        for (int i = 0; i<size; i++){
            if (i < size-1)
                sb.append(elements[i]).append(", ");
            else
                sb.append(elements[i]).append("]");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        NArrayList<String> test = new NArrayList<String>();
        for (int i = 0; i<10; i++){
            test.add(String.valueOf(i));
        }
        System.out.println(test.toString());
        test.add("asd", 5);
        System.out.println(test.toString());
        System.out.println(test.get(10));
        System.out.println(test.indexOf("asd"));
        System.out.println(test.indexOf("1000"));
    }
}
