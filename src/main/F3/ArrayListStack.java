package main.F3;
import java.util.ArrayList;

public class ArrayListStack<E> implements StackInt<E> {
    int stackPointer;
    ArrayList<E> stack;

    ArrayListStack(){
        this.stackPointer = 0;
        this.stack = new ArrayList<>();
    }

    @Override
    public E push(E obj) {
        stack.add(obj);
        stackPointer++;
        return obj;
    }

    @Override
    public E peek() {
        if (stackPointer == 0)  throw new IllegalStateException("Stack is empty");
        return stack.get(stackPointer - 1);
    }

    @Override
    public E pop() {
        if (stackPointer == 0)  throw new IllegalStateException("Stack is empty");
        return stack.remove(--stackPointer);
    }

    @Override
    public boolean isEmpty() {
        return stackPointer == 0;
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