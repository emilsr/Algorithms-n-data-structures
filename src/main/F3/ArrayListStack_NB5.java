package main.F3;
import java.util.ArrayList;

public class ArrayListStack_NB5<E> implements StackInt<E> {
    int stackPointer;
    ArrayList<E> stack;

    ArrayListStack_NB5(){
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
    public boolean empty() {
        return stackPointer == 0;
    }
}