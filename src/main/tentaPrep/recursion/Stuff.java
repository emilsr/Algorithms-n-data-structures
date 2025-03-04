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
    //################################################################################################//
    public static int cost2(int goal){ return cost2(1, goal, 0);}

    private static int cost2(int points, int goal, int currentCost){
        if (points == goal) return currentCost;
        if (points > goal) return -1;

        int ten = cost2(points*3, goal, currentCost+10);
        int five =  cost2(points+4, goal, currentCost+5);

        if (ten == -1 && five == -1) return -1;
        if (five == -1) return ten;
        if (ten == -1) return five;

        return Math.min(five, ten);
    }

    public static int convertFromBinaryIt(String binaryString){
        char[] arr = binaryString.toCharArray();
        int value = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i]=='1') {  //Friendly reminder "" does not work in if statement
                value = value + xPoweredByN(2, arr.length-1-i);
            }
        }
        return value;
    }

    public static int convertFromBinaryRec(String binaryString){
        char[] arr = binaryString.toCharArray();
        return convertFromBinaryRec(arr, arr.length-1);
    }

    private static int convertFromBinaryRec(char[] arr, int index){
        if (index<0) return 0;
        if (arr[index] == '1'){
            return convertFromBinaryRec(arr, index-1) + xPoweredByN(2, arr.length-1-index);
        }
        return convertFromBinaryRec(arr, index-1);
    }

    public static String convertToBinary(int value){
        String binary = "";
        return convertToBinary(value, binary);
    }

    public static String convertToBinary(int value, String str){
        System.out.println("str: " + str + " value: " + value );
        if (value<1) return str;
        if (value%2==0){
            return convertToBinary(value/2, "0"+str);
        } else {
            return convertToBinary(value/2, "1"+str);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 5, 1};
        System.out.println(findLargestInt(arr));

        System.out.println("x=2, n=2: " + xPoweredByN(2,0));

        System.out.println(ROT(9, 1, 0.001));

        for (int i = 0; i < 125; i++){
            System.out.println("Cost1: Goal: " + i + " Solution: " + cost(i));
            System.out.println("Cost2: Goal: " + i + " Solution: " + cost2(i));
        }

        System.out.println("ConvertBinaryIt: 110100100=" + convertFromBinaryIt("110100100"));
        System.out.println("ConvertBinaryRec: 110100100=" + convertFromBinaryRec("110100100"));
        System.out.println("ConvertToBinary: 420=" + convertToBinary(420));
    }
}
