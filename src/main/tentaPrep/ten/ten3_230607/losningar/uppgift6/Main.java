package main.tentaPrep.ten.ten3_230607.losningar.uppgift6;

import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findPair(new int[] {3,4,1,7,9,5,3,6},13)));
        System.out.println(Arrays.toString(findPair(new int[] {3,4,1,7,9,5,3,6},19)));
        System.out.println(Arrays.toString(findPair(new int[] {2,4,6,1,7,12,4,3},12)));
        System.out.println(Arrays.toString(findPair(new int[] {2,4,6,7,12,4,3,6},12)));

    }

    private static int[] findPair(int[] a, int sum) {
        HashSet<Integer> numbers = new HashSet<>();
        for(int number:a){
            if(numbers.contains(sum-number)) return new int[] {number,sum-number};
            numbers.add(number);
        }
        return null;
    }
}
