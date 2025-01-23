package main.f4;

public class NB8<E> {
    private int front, rear, size, maxSize;
    private E[] data;

    public NB8(int initialMaxSiaze){
        size = 0;
        front = 0;
        maxSize = initialMaxSiaze;
        rear = maxSize -1;
        data = (E[]) new Object[maxSize];
    }

    public boolean offer(E element){
        if (size == maxSize){
            reallocate(maxSize*2);
        }
        rear = (rear + 1) % maxSize;
        data[rear] = element;
        size++;
        return true;
    }
    public E peek(){
        if (size!=0) {
            return data[front];
        }
        return null;
    }
    public E poll(){
        if (size==0){
            return null;
        } else {
            size--;
            E element = data[front];
            front = (front+1) % maxSize;
            if (size == maxSize / 4){
                reallocate(maxSize / 2);
            }
            return element;
        }
    }

    private void reallocate(int newMaxSize){
        E[] newData = (E[]) new Object[newMaxSize];
        int j = front;
        for (int i = 0; i < size; i++){
            newData[i] = data[j];
            j = (j + 1) % maxSize;
        }
        front = 0;
        rear = size-1;
        maxSize = newMaxSize;
        data = newData;
    }

    public int getMaxSize() { // Added for testing
        return maxSize;
    }
}