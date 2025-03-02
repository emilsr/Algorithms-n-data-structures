package main.tentaPrep.queue;

/**
 * Methods
 * enqueue(element) – Adds an element to the rear of the queue.
 * dequeue() – Removes and returns the front element of the queue.
 * front() – Returns the front element without removing it.
 * rear() – Returns the rear element without removing it.
 * isEmpty() – Checks if the queue is empty.
 * isFull() – Checks if the queue is full (for a fixed-size circular queue).
 * size() – Returns the number of elements in the queue.
 */

public class CircularQue<E> {
    private E[] que;
    int size;
    int maxSize;
    int rearPointer;
    int frontPointer;

    public CircularQue(int initSize) {
        maxSize = initSize;
        rearPointer = 0;
        frontPointer = 0;
        que = (E[]) new Object[maxSize];
        size=0;
    }

    public boolean enqueue(E element){
        
    }

}
