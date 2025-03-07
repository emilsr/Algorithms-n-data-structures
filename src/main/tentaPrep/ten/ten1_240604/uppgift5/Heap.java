package main.tentaPrep.ten.ten1_240604.uppgift5;

public class Heap {
    int[] arr;
    int size = 0;
    int topPointer;

    public Heap(){
        arr = new int[10];
        for (int i = 0; i< 10; i++){
            arr[i] = Integer.MAX_VALUE;
        }
        size = 0;
        topPointer = 0;
    }

    public boolean offer(int data){
        if (size == arr.length-1) return false;
        if (size == 0){
            arr[0] = data;
        }else {
            for (int i = size-1; i>=0; i--){
                if (arr[i] > data){
                    arr[i+1] = data;
                    break;
                }
                arr[i+1] = arr[i];
            }
        }
        size++;
        return true;
    }


    public int poll(){
        if (size==0) return Integer.MAX_VALUE;
        int t = arr[--size];
        return t;
    }

    public String toStringFull(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< arr.length; i++){
            sb.append(arr[i]).append(", ");
        }
        return sb.toString();
    }

    public String toString(){
        if (size == 0) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = topPointer; i<size-1; i++){
            sb.append(arr[i]).append(", ");
        }
        return sb.toString();
    }

}
