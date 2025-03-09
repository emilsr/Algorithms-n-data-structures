package main.tentaPrep.ten.ten5_220610.uppgift4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        System.out.println(numberJumps(7, 7));
        System.out.println(numberJumps(7, 3));
        System.out.println(numberJumps(1, 4));
    }

    private static int numberJumps(int start, int goal) {
        int [] arr = new int[20];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
        int answer = numberJumps(arr, start, goal, 0);
        if (answer>= Integer.MAX_VALUE/2){
            return -1;
        }
        return answer;
    }

    private static int numberJumps(int[] arr, int position, int goal, int jumps){
        int jumpSize;
        int jumpsU = Integer.MAX_VALUE/2, jumpsD = Integer.MAX_VALUE/2;

        if (position == goal) {
            return jumps;
        }
        jumpSize = (2 * jumps) + 1;
        if (position + jumpSize < arr.length) {
            jumpsU = (numberJumps(arr, position + jumpSize, goal, jumps + 1));
        }
        if (position - jumpSize >= 0) {
            jumpsD =(numberJumps(arr, position - jumpSize, goal, jumps + 1));
        }
        return Math.min(jumpsU, jumpsD);
    }

}
