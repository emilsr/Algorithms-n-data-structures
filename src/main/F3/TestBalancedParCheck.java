package main.F3;

public class TestBalancedParCheck {
    public static void main(String[] args) {
        testBalancedParCheck();
    }

    private static void testBalancedParCheck() {
        String[] testExpressions = {
                "((a + b) * (c - d))",
                "{[a + b] * (c - d)}",
                "((a + b) * [c - d}",
                "((a + b) * (c - d))}",
                "((a + b) * (c - d))"
        };

        for (String expression : testExpressions) {
            boolean result = BalancedParCheck.isBalanced(expression);
            System.out.println("Expression: " + expression);
            System.out.println("Is Balanced: " + result);
            System.out.println();
        }
    }
}