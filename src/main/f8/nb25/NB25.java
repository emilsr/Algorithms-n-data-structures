package main.f8.nb25;

import main.f8.HashTableBucket;

public class NB25 {
    public static void main(String[] args) {
        HashTableBucket<Integer,String> bucket = new HashTableBucket<Integer,String>(10);
        System.out.println(bucket);
        for (int i = 0; i < 10; i++) {
            bucket.put(i, "" + i);
        }
        System.out.println(bucket);

    }
}
