package main.tentaPrep.ten.ten5_220610.losningar.uppgift5;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] v = new int[]{7,3,4,6,1,9,3,8};
        sort(v);
        System.out.println(Arrays.toString(v));
    }

    public static void sort(int[] v){
        int minIndex;
        for(int i=0;i<v.length-1;i++){
            minIndex = i;
            for(int j=i+1;j<v.length;j++){
                if(v[j]<v[minIndex]){
                    minIndex=j;
                }
            }
            swap(v,i,minIndex);
        }
    }

    private static void swap(int[] v, int i, int j) {
        int tmp=v[i];
        v[i]=v[j];
        v[j]=tmp;
    }
}
