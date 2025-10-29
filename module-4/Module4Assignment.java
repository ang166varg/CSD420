// Angela Vargas
// CSD420 4.2 Programming Assignment
// This program compares the time it takes to traverse a LinkedList using
// an iterator vs. using the get(index) method. It tests the performance 
// for 50,000 and 500,000 integers and explains why one is faster.

import java.util.LinkedList;
import java.util.Iterator;

public class Module4Assignment {

    public static void main(String[] args) {
        System.out.println("---------------------------------------------------");
        System.out.println("LinkedList Traversal Time Comparison");
        System.out.println("---------------------------------------------------\n");

        // Test with 50,000 integers
        testLinkedListTraversal(50000);

        // Test with 500,000 integers
        testLinkedListTraversal(500000);
    }

    // Method that tests traversal speed for a given list size
    public static void testLinkedListTraversal(int size) {
        System.out.println("Testing traversal with " + size + " integers...\n");

        LinkedList<Integer> list = new LinkedList<>();

        // Fill the LinkedList with sequential integers
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        // --- Traversal using Iterator ---
        long startIterator = System.nanoTime();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long endIterator = System.nanoTime();
        long iteratorTime = endIterator - startIterator;

        // --- Traversal using get(index) ---
        long startGet = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long endGet = System.nanoTime();
        long getTime = endGet - startGet;

        // Calculate how many times slower get(index) was
        double ratio = (double) getTime / iteratorTime;

        // Print results
        System.out.println("Time using Iterator: " + iteratorTime / 1_000_000.0 + " ms");
        System.out.println("Time using get(index): " + getTime / 1_000_000.0 + " ms");
        System.out.printf("get(index) was approximately %.2f times slower.\n", ratio);
        System.out.println("---------------------------------------------------\n");
    }
}
