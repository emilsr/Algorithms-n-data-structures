package main.F3;

import java.util.EmptyStackException;
import java.util.Stack;
public class PostfixEvaluator {
    public static class SyntaxErrorException extends Exception {
        public SyntaxErrorException(String message) {
            super(message);
        }
    }

    private static final String OPERATORS = "+-*/";
    private Stack<Integer> operandStack;
    public PostfixEvaluator(){
        operandStack = new Stack<>();
    }

    private int evalOp(char op) throws SyntaxErrorException {
        int right = operandStack.pop();
        int left = operandStack.pop();
        return switch (op) {
            case '+' -> left + right;
            case '-' -> left - right;
            case '*' -> left * right;
            case '/' -> left / right;
            default -> throw new SyntaxErrorException("Invalid operator encountered");
        };
    }

    private boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }

    public int eval(String expression) throws SyntaxErrorException {
        String[] tokens = expression.split(" +");
        try {
            for (String nextToken : tokens) {
                var character = nextToken.charAt(0);
                if (Character.isDigit(character)) {
                    operandStack.push(Integer.parseInt(nextToken));
                } else if (isOperator(character)) {
                    if (operandStack.size() < 2) throw new SyntaxErrorException("Operation needs 2 values.");
                    operandStack.push(evalOp(character));
                } else {
                    throw new SyntaxErrorException("Invalid character encountered");
                }
            }
        } catch (EmptyStackException ex){
            throw new SyntaxErrorException("Syntax Error: The stack is empty");
        }
        return operandStack.pop();
    }
}