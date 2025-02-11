package main.f10;

import java.util.Arrays;

public class MinHeap<E extends Comparable<E>>  {

    private int size;
    private E[] data;

    public MinHeap(int size){
        data = (E[]) new Comparable[size];
    }

    public boolean insert (E element){
        if (size == data.length){
            return false; // ToDO fix reallocate... 
        }
        data[size++] = element;
        if (size>1) {
            shiftUp(size);    
        }
        
        return true;
    }

    private void shiftUp(int chiled){
        int parent = chiled/2 -1;
        System.out.println("parent: " + parent);
        if (data[chiled].compareTo(data[parent]) < 0) {
            swap(chiled, parent);
            shiftUp(parent);
        }
    }

    private void shiftDown(int parent){
    }

    private void swap(int a, int b){
        var t = data[a];
        data[a] = data[b];
        data[b] = t;
    }

    public E extract(){
        return null;
    }

    public String toString(){
        return Arrays.toString(data);
    }


    public static void main(String[] args) {
        MinHeap heap = new MinHeap<>(10);
        System.out.println(heap.insert(1));
        //heap.insert(2);
        System.out.println(heap);
    }
}
