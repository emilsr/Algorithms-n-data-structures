package main.f4;
import java.util.Arrays;

public class NB8_1<E>{
    private int front, rear, size, maxSize;
    private E[] data;

    public NB8_1(int initialSize){
        size = 0;
        front = 0;
        maxSize = initialSize;
        rear = 0;
        data = (E[]) new Object[maxSize];
    }

    public boolean offer(E element){
        if(size==maxSize)
            reallocate();
        data[rear] = element;
        rear = rear+1%maxSize;
        size++;
        return true;
    }

    public E peek(){
        if(size==0) throw new IllegalStateException("Queue is empty");
        return data[front];
    }

    public E poll(){
        if(size==0){
            throw new IllegalStateException("Queue is empty");
        }else{
            size--;
            E element = data[front];
            front =front+1%maxSize;
            return element;
        }
    }

    private void reallocate() {
        maxSize*=2;
        data= Arrays.copyOf(data,maxSize);
    }

    public int getMaxSize(){ // added for testing
        return maxSize;
    }   // Here for testing

    public int getSize(){ // added for testing
        return size;
    }         // Here for testing

    @Override
    public String toString() {
        return "NB8_1{" +
                "front=" + front +
                ", rear=" + rear +
                ", size=" + size +
                ", maxSize=" + maxSize +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
