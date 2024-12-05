package F3;

import java.util.Arrays;

/**
 * needed methods
 * E pop()
 * -- Add item on top of stack and return it
 * E push(E item)
 * -- remove and get item on top of stack
 * boolean empty()
 * -- Check if stack is empty
 * E peek()
 * -- return top item on stack without removing it
 * int search(E item)
 * -- get index of item in stack
 */

public class MyStack<E> {
    private E[] stack;
    private int maxSize = 10;
    private int currentSize;

    MyStack() {
        stack = (E[]) new Object[maxSize];
        currentSize = -1;
    }

    public E push(E item) {
        System.out.println("current index: " + currentSize);

        if (currentSize == maxSize-1) {
            System.out.println("Stack is full, call increaseSize()");
            increaseSize();
        }
        stack[++currentSize] = item;
        return item;
    }

    public E pop() {
        if (currentSize == -1) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return stack[currentSize--];
    }

    public E peek() {
        if (currentSize == -1) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return stack[currentSize];
    }

    public boolean isEmpty() {
        return currentSize == -1;
    }

    public int search(E item) {
        for (int i = 0; i <= currentSize; i++) {
            if (stack[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "stack=" + Arrays.toString(stack) +
                ", maxSize=" + maxSize +
                ", currentSize=" + currentSize +
                '}';
    }

    ////////// Healer methods //////////

    private void increaseSize() {
        maxSize = maxSize * 2;
        E [] temp = (E[]) new Object[maxSize];
        for (int i = 0; i <= currentSize; i++) {
            temp[i] = stack[i];
        }
        stack = temp;
    }

    public static void main(String[] args) {
        // Test Integer Stack
        MyStack<Integer> intStack = new MyStack<>();
/*
        // Test push and isEmpty
        System.out.println("Initial stack empty: " + intStack.isEmpty());
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        System.out.println("Stack after pushing 10, 20, 30 is empty: " + intStack.isEmpty());

        // Test peek
        System.out.println("Top of stack: " + intStack.peek());

        // Test search
        System.out.println("Position of 20: " + intStack.search(20));
        System.out.println("Position of 50: " + intStack.search(50));

        // Test pop
        System.out.println("Popped item: " + intStack.pop());
        System.out.println("Top of stack after pop: " + intStack.peek());


 */


        // Test stack expansion
        for (int i = 0; i < 11; i++) {
            intStack.push(i);
            System.out.println(intStack);
        }
        /*
        System.out.println("Stack size after multiple pushes: " + (intStack.search(intStack.peek()) + 1));


        // Test String Stack
        MyStack<String> stringStack = new MyStack<>();
        stringStack.push("Hello");
        stringStack.push("World");
        System.out.println("String stack top: " + stringStack.peek());

         */
    }
}