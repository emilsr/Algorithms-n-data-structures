package main.f13.nb43;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Skriv ett program som löser det generella växlingsproblemet. Användaren får först ange hur många
 * olika valutor det finns och sedan valören på dessa. Därefter får denne ange vilket belopp som skall
 * växlas och programmet svarar med minsta antalet mynt och sedlar som behövs. Lägg till att
 * programmet också skriver ut växeln. Observera att denna algoritm blir mycket ineffektiv och inte
 * klarar annat än mycket små problem.
 */

public class ChangeExchange {

    public String change(int amount, int[] values){
        if (amount < 0){ throw new IllegalArgumentException("amount < 0"); }
        if (values == null || values.length == 0){ throw new IllegalArgumentException("values is null or empty"); }

        return null;
    }


    private final int[] change;
    private HashSet<Integer> prevStates;

    public ChangeExchange(int[] change){
        this.change = change;
        this.prevStates = new HashSet<>();
    }

    public int[] exchange(int amount){
        var result = exchange(amount, 0);
        System.out.println(" identical states");
        return result;
    }

    public int[] exchange(int amount, int pointer){
        if (amount < 0){ return null; }
        for (int i = 0; i < change.length; i++){
            if (change[i] == amount){
                int[] list = new int[change.length];    // List of retuned change???
                list[i] = 1;
                return list;
            }
        }
        var minCoins = Integer.MAX_VALUE;
        int[] coinOrder = new int[change.length];
        for (int i = pointer; i < change.length; i++){
            var attempt = exchange(amount - change[i], i);
            if (attempt != null){
                attempt[i]++;
                var noCoins = Arrays.stream(attempt).sum();
                if (noCoins < minCoins){
                    coinOrder = attempt;
                    minCoins = noCoins;
                }
            }
        }
        return coinOrder;
    }

    public static void main(String[] args) {
        ChangeExchange changeExchange = new ChangeExchange(new int[]{500, 12, 10, 1});
        System.out.println(Arrays.toString(changeExchange.exchange(520)));
    }
}
