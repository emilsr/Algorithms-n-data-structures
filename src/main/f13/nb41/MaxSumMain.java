package main.f13.nb41;

import java.util.Scanner;

public class MaxSumMain {
    public static void main(String[] args) {
        System.out.println("Enter the number of numbers you want to search: ");
        Scanner sc = new Scanner(System.in);
        MaxSum maxSum = new MaxSum(sc.nextInt());
    }
}
