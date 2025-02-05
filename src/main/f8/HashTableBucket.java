package main.f8;

import java.util.Arrays;
import java.util.Iterator;

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
    private int nrOfEntries;

    @SuppressWarnings("unchecked")
    public HashTableBucket(int size){
        table = new SingleLinkedList[size];
    }

    public V put(K key, V value) {
        if (nrOfEntries++ > 0.75 * table.length){
            reHash(table.length*2);
        }
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            table[index] = new SingleLinkedList<Entry<K, V>>();
            table[index].add(new Entry<K, V>(key, value));
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
        }
        return null;
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

     //First implementation of remove()
//     public V remove(K key) {
//         int index = key.hashCode() % table.length;
//         if (index < 0) {index += table.length;}
//         if (table[index] == null) {return null;}
//         for (Entry<K, V> e : table[index]) {
//             if (e.key.equals(key)) {
//                 Entry<K, V> oldValue = e;
//                 table[index] = null;
//                 return oldValue.value;
//             }
//         }
//         return null;
//     }

    public V remove(K key) {
        int index = key.hashCode() % table.length;
        if (index < 0) {index += table.length;}
        if (table[index] == null) {return null;}

        Iterator<Entry<K, V>> itr = table[index].iterator();
        while (itr.hasNext()) {
            Entry<K, V> e = itr.next();
            if (e.key.equals(key)) {
                V removedValue = e.value;
                System.out.println("Log: we found the key: " + e.key + " and value " + e.value);
                itr.remove();
                System.out.println("Log: removed value at Key: " + e.key + " and value " + e.value);
                if (table[index].toString().equals("[]")){
                    table[index] = null;
                }
                return removedValue;
            }
        }
        return null;
    }

    private void reHash(int size){
        SingleLinkedList<Entry<K,V>>[] oldTable = table;
        nrOfEntries = 0;
        table = new SingleLinkedList[size];
        for (SingleLinkedList<Entry<K, V>> e : oldTable) {
            if (e != null) {
                for (Entry<K, V> entry: e){
                    put(entry.key, entry.value);
                }
            }
        }

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

}
