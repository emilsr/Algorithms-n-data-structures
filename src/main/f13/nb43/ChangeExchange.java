package main.f13.nb43;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Skriv ett program som löser det generella växlingsproblemet. Användaren får först ange hur många
 * olika valutor det finns och sedan valören på dessa. Därefter får denne ange vilket belopp som skall
 * växlas och programmet svarar med minsta antalet mynt och sedlar som behövs. Lägg till att
 * programmet också skriver ut växeln. Observera att denna algoritm blir mycket ineffektiv och inte
 * klarar annat än mycket små problem.
 */

public class ChangeExchange {

    private final int[] change;


    public ChangeExchange(int[] change){
        this.change = change;
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
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ange antal olika valörer: ");
        int n = scanner.nextInt();
        int[] denominations = new int[n];

        System.out.println("Ange valörerna (i stigande ordning):");
        for (int i = 0; i < n; i++) {
            denominations[i] = scanner.nextInt();
        }

        System.out.print("Ange belopp att växla: ");
        int amount = scanner.nextInt();

        ChangeExchange changeExchange = new ChangeExchange(denominations);
        int[] result = changeExchange.exchange(amount);

        if (result == null) {
            System.out.println("Det går inte att växla beloppet med angivna valörer.");
        } else {
            System.out.println("Minsta antal mynt och sedlar:");
            for (int i = 0; i < result.length; i++) {
                if (result[i] > 0) {
                    System.out.println(denominations[i] + "-valörer: " + result[i] + " st");
                }
            }
        }
        scanner.close();
    }
}
