package main.tentaPrep.ten.ten4_230315.uppgift6;

public class Main {
    public static void main(String[] args) {
        System.out.println(isHeap(new int []{5,3,8,1,4,6,10} ));
        System.out.println(isHeap(new int []{1,2,3,4,5,6,10} ));
        System.out.println(isHeap(new int []{1,3,8,7,4,10,10} ));
    }

    private static boolean isHeap(int[] v) {
        return isHeap(v, 0, v.length-1);
    }

    private static boolean isHeap(int[] v, int index, int maxIndex){
        if (index*2+1 <= maxIndex){
            if (v[index] > v[2*index+1]) return false;
        }
        if (index*2+2 <= maxIndex){
            if (v[index] > v[2*index+2]) return false;
        }
        if (index == maxIndex) return true;
        return isHeap(v, index+1, maxIndex);
    }
}
