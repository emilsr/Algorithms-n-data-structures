package main.F3;
import java.util.Stack;
import java.util.EmptyStackException;

public class BalancedParCheck {
    private static final String OPEN = "([{" ;
    private static final String CLOSED  = ")]}";     // Order my cause problems...

    public static boolean isBalanced(String expression){
        boolean balanced = true;
        Stack<Character> stack = new Stack<>();
        try {
            for (int i = 0; i < expression.length(); i++){
                char nextChar = expression.charAt(i);
                if (isOpen(nextChar)){
                    stack.push(nextChar);
                } else if (isClosed(nextChar)){
                    char topCh = stack.pop();
                    balanced = OPEN.indexOf(topCh) == CLOSED.indexOf(nextChar);
                }
                if (!balanced){
                    return false;
                }
            }
            return true;
        }catch (EmptyStackException e){
            return false;
        }
    }
    private static boolean isOpen(char ch){
        switch (ch){
            case '(', '[', '{': return true;
            default : return false;
        }
    }
    private static boolean isClosed(char ch){
        switch (ch){
            case '}', ']', ')': return true;
            default : return false;
        }
    }



}