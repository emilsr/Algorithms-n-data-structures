package main.tentaPrep.queue;

import java.util.Arrays;

/**
 * Methods
 * enqueue(element) – Adds an element to the rear of the queue.
 * dequeue() – Removes and returns the front element of the queue.
 * front() – Returns the front element without removing it.
 * rear() – Returns the rear element without removing it.
 * isEmpty() – Checks if the queue is empty.
 * size() – Returns the number of elements in the queue.
 */

public class CircularQue<E> {
    private E[] que;
    int maxSize;
    int rearPointer;
    int frontPointer;
    int size;

    public CircularQue(int initSize) {
        maxSize = initSize;
        rearPointer = -1;
        frontPointer = 0;
        size = 0;
        que = (E[]) new Object[maxSize];
    }

    public boolean enqueue(E element){
        if (rearPointer==frontPointer || size == maxSize){
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
                '}';
    }

    private void reallocate(){
        maxSize = maxSize*2;
        E[] t = (E[]) new Object[maxSize];
        // ToDo this loop 0 -> maxsize/2 but this will copy empty data...
        System.arraycopy(que, 0, t, 0, maxSize/2);
        que = t;
    }

    public static void main(String[] args) {
        CircularQue<Integer> cq= new CircularQue<>(2);
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

    }
}


