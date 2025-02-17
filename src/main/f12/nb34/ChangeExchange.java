package main.f12.nb34;

import java.util.Arrays;

public class ChangeExchange {

    public String change(int amount, int[] values) {
        int[] exchanges = new int[values.length];
        for (int i = 0; i <= values.length-1; i++) {
            while (amount >= values[i]) {
                exchanges[i]++;
                amount=amount-values[i];
            }
        }
        return Arrays.toString(exchanges);
    }

    public static void main(String[] args) {
        int[] test = {100, 50, 10, 5, 1};
        ChangeExchange changeExchange = new ChangeExchange();
        System.out.println(changeExchange.change(763, test));
    }
}
