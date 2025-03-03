package main.tentaPrep.Stack;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 *  * Implementera en stack för data av typen String med hjälp av en enkellänkad lista [6, 17].
 *  * Skriv en metod som kontrollerar om parenteser i en sträng är korrekt matchade (använd en stack) [18].
 */

public class BalanceCheck {
    private int parentheses;
    private int bracers;
    private int brakets;
    private MyStack<String> stack;


    public BalanceCheck(){
        stack = new MyStack<String>();
        parentheses =0;
    }


    public void insertToStack(String str){
        if (str == null) throw new NoSuchElementException();
        for (int i= str.length()-1; i >=0; i--){
            char[] t = str.toCharArray();
            System.out.println(t[i]);
            stack.push(String.valueOf(t[i]));
        }
    }

    public void checkStack(){
        while (!stack.empty()){
            String t = stack.pop();
            if (Objects.equals(t, "(") ){
                parentheses++;
            } else if (Objects.equals(t, ")")) {
                parentheses--;
            }else if (Objects.equals(t, "[")) {
                brakets++;
            }else if (Objects.equals(t, "]")) {
                brakets--;
            }else if (Objects.equals(t, "{")) {
                bracers++;
            }else if (Objects.equals(t, "}")) {
                bracers--;
            }
            System.out.println("String poped: " + t + "current count: " + parentheses);
        }
    }

    public void checkBalance(String str){
        insertToStack(str);
        checkStack();
        if (parentheses<0 || bracers<0 || brakets<0){
            System.out.println("String is open");
        } else if (parentheses>0 || bracers>0 || brakets>0) {
            System.out.println("String is closed");
        } else {
            System.out.println("String is balanced");
        }
    }


    public static void main(String[] args) {
        BalanceCheck bc = new BalanceCheck();
        bc.checkBalance("()");
        bc.checkBalance("{[(asdasdasd)}]");
        bc.checkBalance("{[()))");
    }

}
