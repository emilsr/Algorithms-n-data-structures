package main.F3;
import java.util.ArrayList;

public class ArrayListStack<E> implements StackInt<E> {
    int currentSize;
    ArrayList<E> stack;

    ArrayListStack(){
        this.currentSize = 0;
        this.stack = new ArrayList<>();
    }

    @Override
    public E push(E obj) {
        stack.add(obj);
        currentSize++;
        return obj;
    }

    @Override
    public E peek() {
        return stack.get(currentSize - 1);
    }

    @Override
    public E pop() {
        return stack.remove(--currentSize);
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    public static void main(String[] args) {
        ArrayListStack stack = new ArrayListStack();
        System.out.println(stack.push("Hello"));
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        for (int i = 0; i<20; i++){
            System.out.println(stack.push(i));
        }
    }
}