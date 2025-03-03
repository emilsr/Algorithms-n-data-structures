package main.tentaPrep.queue;

import java.util.Arrays;
import java.util.Iterator;

public class MyCircularQue<E> implements Iterable<E> {
    private E[] que;
    int maxSize;
    int rearPointer;
    int frontPointer;
    int size;

    public MyCircularQue(int initSize) {
        maxSize = initSize;
        rearPointer = -1;
        frontPointer = 0;
        size = 0;
        que = (E[]) new Object[maxSize];
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr(frontPointer);
    }

    private class Itr<E> implements Iterator {
        int current;

        public Itr(int index){
            current = 0;
        }

        @Override
        public boolean hasNext() {
            return que[current] != null;
        }

        @Override
        public Object next() {
            E t = (E) que[current];
            current = (current+1) % maxSize;
            return t;
        }

    }

    public boolean enqueue(E element){
        if (size == maxSize){
            reallocate();
        }
        que[++rearPointer%maxSize] = element;
        size++;
        return true;
    }

    public E dequeue(){
        E t =  que[frontPointer];
        que[frontPointer] = null;
        frontPointer = (frontPointer % maxSize)+1;
        size--;
        return t;
    }

    public E peek(){
        return que[frontPointer];
    }

    public int size(){
        return size;
    }


    @Override
    public String toString() {
        return "CircularQue{" +
                "que=" + Arrays.toString(que) +
                ", maxSize=" + maxSize +
                ", rearPointer=" + rearPointer +
                ", frontPointer=" + frontPointer +
                ", size=" + size +
                '}';
    }

    private void reallocate(){
        int newMaxSize = maxSize*2;
        E[] t = (E[]) new Object[newMaxSize];
        int j = frontPointer;
        for (int i = 0; i < size; i++){
            t[i] = que[j];
            j = (j+1) % maxSize;
        }
        frontPointer=0;
        rearPointer=size-1;
        maxSize = newMaxSize;
        que = t;
    }

    public static void main(String[] args) {
        MyCircularQue<Integer> cq= new MyCircularQue<>(2);
        System.out.println("peek: " + cq.peek());
        System.out.println("add element 1: " + cq.enqueue(1));
        System.out.println("add element 2: " +cq.enqueue(2));
        System.out.println("add element 3: " +cq.enqueue(3));
        System.out.println(cq);
        System.out.println("add element 4: " +cq.enqueue(4));
        System.out.println("add element 5: " +cq.enqueue(5));
        System.out.println(cq);
        System.out.println("deque element: " +cq.dequeue());
        System.out.println("deque element: " +cq.dequeue());
        System.out.println(cq);
        System.out.println("peek: " + cq.peek());
        System.out.println("deque element: " +cq.dequeue());
        System.out.println(cq);
        System.out.println("size: " + cq.size());
        System.out.println("deque element: " +cq.dequeue());
        System.out.println("deque element: " +cq.dequeue());
        System.out.println("deque element: " +cq.dequeue());
        for (int i = 5; i<15; i++){
            System.out.println("add element " + i + ": " + cq.enqueue(i));
        }
        System.out.println(cq);

        Iterator itrTest = cq.iterator();
        System.out.println("Itr: ");
        while (itrTest.hasNext()){
            System.out.println(itrTest.next());
        }

    }
}


