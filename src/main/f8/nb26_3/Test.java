package main.f8.nb26_3;

public class Test {
    public static void main(String[] args) {
        // Create a new MyHashMap instance
        MyHashMap<String, Integer> map = new MyHashMap<>();

        // Test basic put and get operations
        System.out.println("Testing basic put and get operations:");
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println("Value for 'one': " + map.get("one"));
        System.out.println("Value for 'two': " + map.get("two"));
        System.out.println("Value for 'three': " + map.get("three"));
        System.out.println("Value for non-existent key: " + map.get("four"));

        // Test updating existing values
        System.out.println("\nTesting value updates:");
        Integer oldValue = map.put("one", 100);
        System.out.println("Old value for 'one': " + oldValue);
        System.out.println("New value for 'one': " + map.get("one"));

        // Test rehashing by adding more elements
        System.out.println("\nTesting rehashing by adding more elements:");
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        map.put("ten", 10);

        // Verify all values after rehashing
        System.out.println("Values after rehashing:");
        String[] keys = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        for (String key : keys) {
            System.out.println(key + ": " + map.get(key));
        }

        // Test null handling
        System.out.println("\nTesting null handling:");
        try {
            map.put(null, 1);
        } catch (NullPointerException e) {
            System.out.println("Caught expected NullPointerException for null key: " + e.getMessage());
        }

        try {
            map.put("test", null);
        } catch (NullPointerException e) {
            System.out.println("Caught expected NullPointerException for null value: " + e.getMessage());
        }

        try {
            map.get(null);
        } catch (NullPointerException e) {
            System.out.println("Caught expected NullPointerException for null key in get: " + e.getMessage());
        }
    }
}
