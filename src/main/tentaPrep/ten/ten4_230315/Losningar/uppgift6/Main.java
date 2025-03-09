package main.tentaPrep.ten.ten4_230315.Losningar.uppgift6;

public class Main {
    public static void main(String[] args) {
        System.out.println(isHeap(new int []{5,3,8,1,4,6,10} ));
        System.out.println(isHeap(new int []{2,5,3,5,6,4,10,7} ));
    }

    private static boolean isHeap(int[] v) {
        for(int i=1;i<v.length;i++){
            if(v[i]<v[(i-1)/2]) return false;
        }
        return true;
    }
}
