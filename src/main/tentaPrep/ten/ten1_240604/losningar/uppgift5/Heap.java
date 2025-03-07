package main.tentaPrep.ten.ten1_240604.losningar.uppgift5;

public class Heap {

    static final int MAXSIZE = 1000;
    int[] a;
    int size;

    public Heap(){
        a = new int[MAXSIZE];
        size=0;
    }

    public boolean offer(int data){
        if(size==MAXSIZE) return false;
        a[size]=data;
        reheapOffer(size);
        size++;
        return true;
    }

    private void reheapOffer(int pos) {
        if(pos!=0 && a[pos]<a[parent(pos)]){
            swap(pos, parent(pos));
            reheapOffer(parent(pos));
        }
    }

    private void swap(int n, int m){
        int tmp = a[n];
        a[n] = a[m];
        a[m] = tmp;
    }

    private int parent(int p){
        return (p-1)/2;
    }

    public int poll(){
        if(size==0)
            return Integer.MAX_VALUE;
        int returnData=a[0];
        a[0]=a[--size];
        reheapPoll(0);
        return returnData;
    }

    private void reheapPoll(int pos){
        if(leftChild(pos)>size-1) return;//saknar barn
        if(rightChild(pos)>size-1 || a[leftChild(pos)]<a[rightChild(pos)]){//saknar högerbarn eller vänsterbarnet är minst
            if(a[pos]>a[leftChild(pos)]){
                swap(pos,leftChild(pos));
                reheapPoll(leftChild(pos));
            }
            return;
        }
        if(a[pos]>a[rightChild(pos)]){
            swap(pos,rightChild(pos));
            reheapPoll(rightChild(pos));
        }
    }

    private int leftChild(int p){
        return 2*p+1;
    }
    private int rightChild(int p){
        return 2*p+2;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<size-1;i++){
            sb.append(a[i]);
            sb.append(",");
        }
        sb.append(a[size-1]);
        return sb.toString();
    }
}
