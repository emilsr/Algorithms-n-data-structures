package F3;

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
 *

 */

public class MyStack<E> {
    private E[] stack;
    private int maxSize = 10;
    private int currentSize;

    MyStack() {
        E[] stack = (E[]) new Object[maxSize];
        currentSize = -1;
    }

    public E push(E item) {
        if (currentSize == maxSize) {
            return null;
            // handle maxSize increase
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
        for (int i = 0; i < currentSize; i++) {
            if (stack[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    ////////// Healer methods //////////

    private void increaseSize() {
        E [] temp = (E[]) new Object[maxSize*2];
        for (int i = currentSize + 1; i > 0; i--) {
            temp[i] = stack[i];
        }
        stack = temp;
    }
}