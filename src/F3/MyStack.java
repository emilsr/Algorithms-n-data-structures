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
        stack = (E[]) new Object[maxSize];
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

    public static void main(String[] args) {
        // Test Integer Stack
        MyStack<Integer> intStack = new MyStack<>();

        // Test push and isEmpty
        System.out.println("Initial stack empty: " + intStack.isEmpty());
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        System.out.println("Stack after pushing 10, 20, 30 is empty: " + intStack.isEmpty());
        /*

        // Test peek
        System.out.println("Top of stack: " + intStack.peek());

        // Test search
        System.out.println("Position of 20: " + intStack.search(20));
        System.out.println("Position of 50: " + intStack.search(50));

        // Test pop
        System.out.println("Popped item: " + intStack.pop());
        System.out.println("Top of stack after pop: " + intStack.peek());

        // Test stack expansion
        for (int i = 0; i < 10; i++) {
            intStack.push(i * 100);
        }
        System.out.println("Stack size after multiple pushes: " + (intStack.search(intStack.peek()) + 1));

        // Test String Stack
        MyStack<String> stringStack = new MyStack<>();
        stringStack.push("Hello");
        stringStack.push("World");
        System.out.println("String stack top: " + stringStack.peek());

         */
    }
}