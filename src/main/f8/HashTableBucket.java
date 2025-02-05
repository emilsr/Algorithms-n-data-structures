package main.f8;

import java.util.Arrays;

public class HashTableBucket <K, V>{

    private static class Entry<K, V>{
        private K key;
        private V value;
        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return key + "->" + value;
        }

    }
    private SingleLinkedList<Entry<K,V>>[] table;

    @SuppressWarnings("unchecked")
    public HashTableBucket(int size){
        table = new SingleLinkedList[size];
    }

    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            table[index] = new SingleLinkedList<Entry<K, V>>();
            table[index].add(new Entry<K, V>(key, value));
            return null;
        } else {
            V oldValue;
            for (Entry<K, V> e : table[index]) {
                if (e.key.equals(key)) {
                    oldValue = e.value;
                    e.value = value;
                    return oldValue;
                }
            }
            table[index].add(0, new Entry<K, V>(key, value));
            return null;
        }
    }

    public V get(K key) {
        int index = key.hashCode() % table.length;
        if (index < 0) {index += table.length;}
        if (table[index] == null) {return null;}
        for (Entry<K, V> e : table[index]) {
            if (e.key.equals(key)) {
                return e.value;
            }
        }
        return null;
    }

    public V remove(K key) {
        int index = key.hashCode() % table.length;
        if (index < 0) {index += table.length;}
        if (table[index] == null) {return null;}
        for (Entry<K, V> e : table[index]) {
            if (e.key.equals(key)) {
                Entry<K, V> oldValue = e;
                table[index] = null;
                return oldValue.value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            sb.append(i).append(": ");
            if (table[i] != null) {
                sb.append(table[i].toString());
            } else {
                sb.append("null");
            }
            sb.append("\n");
        }
        return sb.toString();
    }


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
