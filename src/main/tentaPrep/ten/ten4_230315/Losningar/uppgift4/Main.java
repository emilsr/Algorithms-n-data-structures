package main.tentaPrep.ten.ten4_230315.Losningar.uppgift4;

import java.util.Arrays;

public class Main {
    static int calls;
    public static void main(String[] args) {
        calls = 0;
        System.out.println("Antal: " + nrOfPushes(1,4)+", calls: "+calls);
        calls = 0;
        System.out.println("Antal: " + nrOfPushes(12,11)+", calls: "+calls);
        calls = 0;
        System.out.println("Antal: " + nrOfPushes(8,12)+", calls: "+calls);
        calls = 0;
        System.out.println("Antal: " + nrOfPushesD(1,4)+", calls: "+calls);
        calls = 0;
        System.out.println("Antal: " + nrOfPushesD(12,11)+", calls: "+calls);
        calls = 0;
        System.out.println("Antal: " + nrOfPushesD(8,12)+", calls: "+calls);
    }

    private static int nrOfPushesD(int startTime, int endTime) {
        int[] memo = new int[12];
        Arrays.fill(memo,-1);
        memo[endTime%12] = 0;
        return nrOfPushesD(startTime % 12,endTime % 12,0, memo);
    }

    private static int nrOfPushesD(int time, int endTime, int nrOfPushes, int[] memo) {
        calls++;
        if(memo[time] != -1) return memo[time];
        if(nrOfPushes == 15) return Integer.MAX_VALUE;
        int result = Math.min(nrOfPushesD((time+7)%12, endTime,nrOfPushes+1,memo),nrOfPushesD((time+10)%12,endTime,nrOfPushes+1,memo));
        if(result == Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return memo[time] = result + 1;
    }
    private static int nrOfPushes(int startTime, int endTime) {
        return nrOfPushes(startTime % 12,endTime % 12,0);
    }

    private static int nrOfPushes(int time, int endTime, int nrOfPushes) {
        calls++;
        if(time == endTime) return 0;
        if(nrOfPushes == 15) return Integer.MAX_VALUE/2;
        return 1+Math.min(nrOfPushes((time+7)%12, endTime,nrOfPushes+1),nrOfPushes((time+10)%12,endTime,nrOfPushes+1));
    }

}