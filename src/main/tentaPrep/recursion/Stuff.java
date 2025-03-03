package main.tentaPrep.recursion;

import java.awt.*;

public class Stuff {
    public static int findLargestInt (int[] arr){
        return findLargestInt(arr, 0, 0);
    }

    private static int findLargestInt(int[] arr, int index, int currentMax){
        if (arr.length == index) return currentMax;
        if (arr[index] > currentMax) currentMax = arr[index];
        return findLargestInt(arr, index+1, currentMax);
    }
    //################################################################################################//
    public static int xPoweredByN(int x, int n){
        if (n==0){
            System.out.println("fel");
            return 1;
        }
        return xPoweredByN(x, n, 1);
    }
    private static int xPoweredByN(int x, int n, int product){
        if (n==0) return product;
        product = product * x;
        return xPoweredByN(x, n-1, product);
    }
    //################################################################################################//
    public static double ROT(double n, double a, double e){
        if (Math.abs((a*a)-n)<e){
            return a;
        }
        a = ((a*a) + n) / (2*a);
        return ROT(n, a, e);
    }
    //################################################################################################//
    public static int cost(int goal){
        return cost(1, goal);
    }

    public static int cost(int points, int goal){
        if (points == goal) return 0;
        if (points > goal) return -1;

        int ten = cost(points*3, goal);
        int five = cost(points+4, goal);

        if (ten == -1 && five ==-1) return -1;
        if (ten == -1) return five+5;
        if (five == -1) return ten+10;

        return Math.min(five+5, ten+10);
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 5, 1};
        System.out.println(findLargestInt(arr));

        System.out.println("x=2, n=2: " + xPoweredByN(2,2));

        System.out.println(ROT(9, 1, 0.001));

        for (int i = 0; i < 125; i++){
            System.out.println("Goal: " + i + " Solution: " + cost(i));
        }
    }
}
