package main.f8.nb26_3;

public class MyHashMap<K, V> {
    private class Entry<K,V> {
        private K key;
        private V value;
        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
        public String toString(){
            return key + "->" + value;
        }
    }

    private Entry<K, V>[] table;
    private int nrOfEntries;

    public MyHashMap(){
        table = new Entry[10];
    }

    public V get(K key){
        if (key == null) throw new NullPointerException("key can't be null");

        int index = getHashKey(key);
        while (table[index] != null){
            if (table[index].key.equals(key) && table[index].key != null){
                return table[index].value;
            }
            index = (index + 1) % table.length;
        }
        return null;
    }

    public V put(K key, V value){
        if (key == null || value == null) throw new NullPointerException("key or value is null, key=" + key + ", value=" + value);

        int index = getHashKey(key);
        // First check if key exists
        int probeIndex = index;
        while (table[probeIndex] != null) {
            if (table[probeIndex].key.equals(key)) {
                V oldValue = table[probeIndex].value;
                table[probeIndex].value = value;
                return oldValue;
            }
            probeIndex = (probeIndex + 1) % table.length;
            if (probeIndex == index) break; // Full table check
        }

        // If we need to add a new entry
        if (nrOfEntries >= 0.75 * table.length) {
            reHash(table.length * 2);
            index = getHashKey(key);
        }

        // Find next available slot
        while (table[index] != null && table[index].key != null) {
            index = (index + 1) % table.length;
        }

        table[index] = new Entry<>(key, value);
        nrOfEntries++;
        return null;
    }

    private void reHash(int newSize){
        Entry[] oldTable = table;
        table = new Entry[newSize];
        nrOfEntries = 0;
        for (Entry<K, V> entry : oldTable){
            if (entry != null && entry.key != null) put(entry.key, entry.value);
        }
    }

    private int getHashKey(K key){
        int hashKey = key.hashCode() % table.length;
        if (hashKey < 0) hashKey += table.length;
        return hashKey;
    }
}
