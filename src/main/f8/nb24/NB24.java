package main.f8.nb24;

import main.f8.HashTableBucket;

public class NB24 {
    public static void main(String[] args) {

        HashTableBucket<Integer,String> bucket = new HashTableBucket<Integer,String>(10);
        System.out.println("put a at index 1: " + bucket.put(1, "a"));
        System.out.println("put a at index 2: " + bucket.put(2, "a"));
        System.out.println("Print index 1: " + bucket.get(1));
        System.out.println("Print index 2: " + bucket.get(2));
        System.out.println("put b at index 2: " + bucket.put(2, "b"));
        System.out.println("get index 1: " + bucket.get(1));
        System.out.println("get index 2: " + bucket.get(2));
        System.out.println(bucket);
        System.out.println("remove(2): " + bucket.remove(2));
        System.out.println(bucket);
        System.out.println("remove(2): " + bucket.remove(2));
        System.out.println(bucket);
    }
}
