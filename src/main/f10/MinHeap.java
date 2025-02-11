package main.f10;


public class MinHeap<E extends Comparable<E>>  {

    private int size;
    private E[] data;
    private int nextPos;

    public MinHeap(int size){
        this.size = size;
        data = (E[]) new Comparable[size];
        nextPos = 0;
    }

    public boolean insert (E data){
        
        return true;
    }

    public E extract(){
        return null;
    }


}
