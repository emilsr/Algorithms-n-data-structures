package main.f13.nb41;


import java.util.Random;
import java.util.Scanner;

/**
 * Skriv ett program som slumpar n stycken heltal mellan -1000 och 1000. Användaren anger n.
 * Programmet beräknar sedan den maximala delsekvenssumman med hjälp av ett funktionsanrop av
 * en funktion som använder en söndra och härska algoritm. Den skriver sedan ut vad summan blev och
 * hur många anrop till funktionen som gjordes.
 */
public class MaxSum {
    int nrOfNumbers;
    int[] numbers;
    int nrOfCalls;

    public MaxSum(int n) {
        this.nrOfNumbers = n;
        this.numbers = new int[n];

        Random rand = new Random();
        for (int i = 0; i < nrOfNumbers; i++) {
            this.numbers[i] = rand.nextInt(2001) - 1000;
        }
        System.out.println("Best sequence: " + getBestSequence(numbers, 0, nrOfNumbers-1));
        System.out.println("Number of calls: " + nrOfCalls);
    }

    public int getBestSequence(int[] arr , int left, int right) {
        nrOfCalls++;
        if (left > right) { return 0;}
        if (left == right) { return Math.max(0, numbers[left]); }
        int mid = (left + right) / 2;
        int leftSum = 0, maxLeft = 0;
        for (int i = mid; i >= left; i--) {
            leftSum += arr[i];
            maxLeft = Math.max(maxLeft, leftSum);
        }
        int rightSum = 0, maxRight = 0;
        for (int i = mid+1; i <= right; i++) {
            rightSum += arr[i];
            maxRight = Math.max(maxRight, rightSum);
        }
        int sum = maxLeft + maxRight;
        return Math.max(sum, Math.max(getBestSequence(arr, left, mid), getBestSequence(arr, mid + 1, right)));
    }
}
