package main.f8;

public class HashTableBucket <K, V>{

    private static class Entry<K, V>{
        private K key;
        private V value;
        public Entry(K key, V value){
            this.key = key;
            this.value = value;
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

    public static void main(String[] args) {
        HashTableBucket<Integer,String> bucket = new HashTableBucket<Integer,String>(10);
        System.out.println(bucket.put(1, "a"));
        System.out.println(bucket.put(2, "b"));
        System.out.println(bucket.get(1));
        System.out.println(bucket.get(2));
        System.out.println(bucket);
    }
}
