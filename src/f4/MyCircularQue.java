package f4;

import java.lang.reflect.Array;

/**
 *  Circular array
 *
 *  Data
 *  -- int front, rear, size, maxSize
 *  -- E[] data
 *
 *  Pinter to head and rear of que
 *  if rear = maxSize
 *      move que so rear = 0
 *  if front = max Size
 *      set front = 0
 *  if rear = head
 *      Que is full, and we need to reallocate
 *
 *  Methods
 *  boolean add(E e)
 *  -- trys to add element to Que. Return ture if successful, throw if not
 *  boolean offer(E e)
 *  -- trys to add element to Que. Return ture if successful, return false if fails
 *  E remove()
 *  -- remove and return element in the front of the Que, throw exemption oif Que is empty
 *  E poll()
 *  -- remove and return element in the front of the Que, return null if Que is empty
 *  E element()
 *  -- returns first element in Que, throws if Que is empty
 *  E peek()
 *  -- returns first element in Que, return null if Que is empty
 *
 *  inmp isEmpty and size from interface
 *
 */
public class MyCircularQue<E> {
    private int front, rear, size, maxSize;
    private E[] data;

    public MyCircularQue(int maxSize){
        this.maxSize = maxSize;
        front = -1;
        rear = maxSize-1;
        size = 0;
        data = (E[]) new Object[maxSize];
    }

    public boolean add(E element){
        if (rear == maxSize) {
            return false; //ToDo Move que so rear = 0 
        } else if (front == maxSize) {
            return false; //ToDo set frnt = 0; 
        } else if(rear == front){   // Maby this check will need to be moved...
            return false; //ToDo imp reallocate 
        }
        rear = (rear+1) % maxSize;
        data[rear] = element;
        size++;
        return true;
    }

    public E peek(){
        if (size==0) {
            return null;
        } return data[front];
    }

    public E poll(){
        if (size == 0) {
            throw new IllegalArgumentException("Que is empty...");
        }
        size--;
        E element = data[front];
        front = (front + 1) % maxSize;
        return element;
    }


    @Override 
    public String toString(){
        StringBuilder sb = new StringBuilder("My Que [" );
        for (int i = 0; i < maxSize; i++){
            sb.append(data[i] + " ");
        }
        sb.append("] fronmt: " + front +
        ", rear: " + rear  + 
        ", size: " + size +
        ", maxSize: " + maxSize
        );
        return sb.toString();
    }


    public static void main(String[] args) {
        MyCircularQue<String> testQ = new MyCircularQue<String>(10);

        testQ.add("A");
        testQ.add("B");
        System.out.println(testQ);
        System.out.println("Removed: " + testQ.poll());
        System.out.println(testQ);
        System.out.println("Removed: " + testQ.poll());
        System.out.println(testQ);
        System.out.println("Removed: " + testQ.poll());
        System.out.println(testQ);
        System.out.println("Removed: " + testQ.poll());

    }

}
