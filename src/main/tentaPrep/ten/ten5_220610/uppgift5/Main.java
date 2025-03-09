package main.tentaPrep.ten.ten5_220610.uppgift5;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] v = new int[]{7,3,4,6,1,9,3,8};
        sort(v);
        System.out.println(Arrays.toString(v));
    }

    public static void sort(int[] v) {
        int localMin;
        int localMinIndex;

        for (int i = 0; i< v.length-1; i++){
            localMin = v[i];
            localMinIndex = i;
            System.out.println(Arrays.toString(v));
            System.out.println("state: i="+i + " localMin=" + localMin + " localMinIndex="+ localMinIndex);
            for (int j = i+1; j < v.length; j++){
                if (localMin > v[j]) {
                    localMin = v[j];
                    localMinIndex = j;
                }
            }
            if (localMinIndex != i){
                v[localMinIndex] = v[i];
                v[i] = localMin;
            }
        }
    }
}


