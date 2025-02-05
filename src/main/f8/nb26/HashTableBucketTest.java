package main.f8.nb26;

import main.f8.HashTableBucket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HashTableBucketTest {

    private HashTableBucket<String, Integer> hashTable;

    @BeforeEach
    void setUp() {
        hashTable = new HashTableBucket<>(4);
    }

    @Test
    void testPutAndGet() {
        assertNull(hashTable.put("one", 1));
        assertNull(hashTable.put("two", 2));
        assertEquals(1, hashTable.get("one"));
        assertEquals(2, hashTable.get("two"));
    }

    @Test
    void testPutUpdate() {
        assertNull(hashTable.put("key", 10));
        assertEquals(10, hashTable.get("key"));
        assertEquals(10, hashTable.put("key", 20)); // Updating value
        assertEquals(20, hashTable.get("key"));
    }

    @Test
    void testRemove() {
        hashTable.put("alpha", 100);
        hashTable.put("beta", 200);
        assertEquals(100, hashTable.remove("alpha"));
        assertNull(hashTable.get("alpha"));
        assertEquals(200, hashTable.get("beta"));
    }

    @Test
    void testRemoveNonExistent() {
        assertNull(hashTable.remove("nonexistent"));
    }

    @Test
    void testRehash() {
        hashTable.put("a", 1);
        hashTable.put("b", 2);
        hashTable.put("c", 3);
        hashTable.put("d", 4);
        hashTable.put("e", 5); // Should trigger rehash

        assertEquals(1, hashTable.get("a"));
        assertEquals(5, hashTable.get("e"));
    }
}
