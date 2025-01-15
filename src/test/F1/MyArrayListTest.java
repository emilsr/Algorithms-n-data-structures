package test.F1;

import main.F1.MyArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {

    @Test
    public void testAddElement() {
        MyArrayList<Integer> list = new MyArrayList<>();
        assertTrue(list.add(1));
        assertTrue(list.add(2));
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

    @Test
    public void testAddElementAtIndex() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1, 99);
        assertEquals(99, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));
    }

    @Test
    public void testGetElement() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("A");
        list.add("B");
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
    }

    @Test
    public void testGetElementOutOfBounds() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("A");
        assertNull(list.get(5)); // Index out of bounds
    }

    @Test
    public void testRemoveElement() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.remove(1);
        assertEquals(30, list.get(1));
        assertEquals(2, list.indexOf(30));
        assertEquals(-1, list.indexOf(20)); // Removed element not found
    }

    @Test
    public void testRemoveElementOutOfBounds() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        list.remove(5); // Should not throw an exception, just print an error
        assertEquals(10, list.get(0));
    }

    @Test
    public void testSetElement() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("A");
        list.add("B");
        String old = list.set(0, "Z");
        assertEquals("A", old);
        assertEquals("Z", list.get(0));
    }

    @Test
    public void testSetElementOutOfBounds() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("A");
        assertNull(list.set(5, "Z")); // Index out of bounds
    }

    @Test
    public void testIndexOfElement() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals(1, list.indexOf("B"));
        assertEquals(-1, list.indexOf("D"));
    }

    @Test
    public void testIncreaseSize() {
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add(i);
        }
        assertEquals(15, list.indexOf(14)); // Checks all elements were added successfully
    }

    @Test
    public void testToString() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("A");
        list.add("B");
        assertTrue(list.toString().contains("A"));
        assertTrue(list.toString().contains("B"));
    }




    public static void main(String[] args) {
        System.out.println("Running tests for MyArrayList...");

        MyArrayListTest test = new MyArrayListTest();

        try {
            test.testAddElement();
            System.out.println("testAddElement: PASSED");

            test.testAddElementAtIndex();
            System.out.println("testAddElementAtIndex: PASSED");

            test.testGetElement();
            System.out.println("testGetElement: PASSED");

            test.testGetElementOutOfBounds();
            System.out.println("testGetElementOutOfBounds: PASSED");

            test.testRemoveElement();
            System.out.println("testRemoveElement: PASSED");

            test.testRemoveElementOutOfBounds();
            System.out.println("testRemoveElementOutOfBounds: PASSED");

            test.testSetElement();
            System.out.println("testSetElement: PASSED");

            test.testSetElementOutOfBounds();
            System.out.println("testSetElementOutOfBounds: PASSED");

            test.testIndexOfElement();
            System.out.println("testIndexOfElement: PASSED");

            test.testIncreaseSize();
            System.out.println("testIncreaseSize: PASSED");

            test.testToString();
            System.out.println("testToString: PASSED");
        } catch (AssertionError e) {
            System.err.println("A test failed: " + e.getMessage());
        }
    }
}
