package main.tentaPrep.ten.ten4_230315.uppgift4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Antal: " + nrOfPushes(1,4));
        System.out.println("Antal: " + nrOfPushes(12,11));
        System.out.println("Antal: " + nrOfPushes(8,12));

    }

    private static int nrOfPushes(int startTime, int endTime) {
        int val = nrOfPushesRec(startTime, endTime, 0);
        if (val >= Integer.MAX_VALUE/2) return -1;
        return val;
    }

    private static int nrOfPushesDy(int startTime, int endTime) {
        int[] memo = new int[12];
        Arrays.fill(memo , -1);
        return nrOfPushesDyn(startTime, endTime, memo);
    }

    private static int nrOfPushesRec(int time, int target, int steps){
        if (time > 12) time=time-12;
        if (target == time) return steps;
        if (steps > 15) return Integer.MAX_VALUE/2;
        return Math.min(nrOfPushesRec(time+10, target, steps+1), nrOfPushesRec(time+7, target, steps+1));
    }

    private static int nrOfPushesDyn(int time, int target, int[] memo){
        if (time > 12) time = time-12;
        if (memo[time] != -1){
            return memo[time];
        }
    // toDo
    return -1;
    }


}