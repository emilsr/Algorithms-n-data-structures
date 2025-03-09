package main.tentaPrep.ten.ten4_230315.Losningar.uppgift3;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        System.out.println(checkBrackets("(()()(()())((())))()"));
        System.out.println(checkBrackets("(((){}[])[]{()}){}"));
        System.out.println(checkBrackets("[{}([]{})]"));
        System.out.println(checkBrackets("({)}"));
        System.out.println(checkBrackets("())"));
        System.out.println(checkBrackets("[[]"));
        System.out.println(checkBrackets("{[]([(){]}}"));
    }

    private static boolean checkBrackets(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char c;
        for(int i=0;i<s.length();i++){
            c = s.charAt(i);
            if(leftBracket(c)){
                stack.push(c);
            }else if(rightBracket(c)){
                if(stack.isEmpty()) return false;
                if(!matches(stack.pop(),c)) return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }

    private static boolean matches(char bracketLeft, char bracketRight){
        if(bracketLeft == '(') return bracketRight == ')';
        if(bracketLeft == '[') return bracketRight == ']';
        if(bracketLeft == '{') return bracketRight == '}';
        return false;
    }
    private static boolean leftBracket(char c) {
        return c =='(' || c =='{' || c =='[';
    }

    private static boolean rightBracket(char c) {
        return c ==')' || c =='}' || c ==']';
    }
}
