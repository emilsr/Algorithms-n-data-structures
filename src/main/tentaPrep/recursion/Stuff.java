package main.tentaPrep.recursion;

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
    


    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 5, 1};
        System.out.println(findLargestInt(arr));

        System.out.println("x=2, n=2: " + xPoweredByN(2,2));

        System.out.println(ROT(9, 1, 0.001));
    }
}
