package main.f10.nb30;

public class MinHeap<E extends Comparable<E>>  {

    private int size;
    private E[] data;

    public MinHeap(int maxSize){
        data = (E[]) new Comparable[maxSize];
    }

    public boolean insert(E element){
        if (size == data.length) reallocate(size*2);
        data[size] = element;
        shiftUp(size++);    
        return true;
    }

    private void reallocate(int newMaxSize){
        E[] t = (E[]) new Comparable[newMaxSize];
        for (int i = 0; i<size; i++){
            t[i] = data[i];
        } 
        data = t;
    }

    public E extract(){
        var t = data[0];
        size--;
        shiftDown(0);
        return t;
    }

    private void shiftDown(int parent){
        if (parent>=size) return;
        var shiledA = parent*2 +1;
        var shiledB = shiledA+1;
        if (data[shiledA].compareTo(data[shiledB])<0) {
            swap(parent, shiledA);
            shiftDown(shiledA);
        } else {
            swap(parent, shiledB);
            shiftDown(shiledB);
        }
        
    }

    private void shiftUp(int chiled){
        if (chiled==0) return;
        int parent = chiled/2 -1;
        if (parent<0) parent = 0;
        if (data[chiled].compareTo(data[parent]) < 0) {
            swap(chiled, parent);
            shiftUp(parent);
        }
    }

    private void swap(int a, int b){
        var t = data[a];
        data[a] = data[b];
        data[b] = t;
    }

    public StringBuilder string(){
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i<size; i++){
            sb.append(data[i]+ " ");
        }
        sb.append("]");
        return sb;
    }


    public static void main(String[] args) {
        MinHeap heap = new MinHeap<>(2);
        System.out.println(heap.insert(2));
        System.out.println(heap.insert(1));
        System.out.println(heap.insert(4));
        System.out.println(heap.insert(5));
        System.out.println(heap.insert(3));
        System.out.println(heap.string());
        System.out.println(heap.extract());
        System.out.println(heap.string());
    }
}
