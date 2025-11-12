/*
 * Angela Vargas
 * CSD420
 * 6.2 Programming Assignment
 * 
 * This program demonstrates two implementations of the Bubble Sort algorithm using generics:
 *  1. bubbleSort(E[] list) — uses the Comparable interface to sort elements.
 *  2. bubbleSort(E[] list, Comparator<? super E> comparator) — uses a Comparator to sort elements.
 * 
 * The goal is to show how Bubble Sort can work with any object type as long as it either:
 *   - Implements Comparable, or
 *   - Is provided with a Comparator.
 * 
 * Bubble Sort works by repeatedly swapping adjacent elements that are out of order until
 * the list is fully sorted.
 */

import java.util.Comparator;

public class Bubble_Sort {

    // Main method for testing both bubble sort versions
    public static void main(String[] args) {

        // Test 1: Sorting an array of Integers using Comparable
        Integer[] numbers = { 5, 3, 4, 9, 0, 1, 2, 7, 6, 8 };
        System.out.println("Original Integer Array:");
        printArray(numbers);

        bubbleSort(numbers); // Using Comparable
        System.out.println("\nSorted Integer Array (Comparable):");
        printArray(numbers);

        // Test 2: Sorting an array of color names using Comparator (reverse order)
        String[] colors = { "Blue", "Red", "Green", "Yellow", "Purple" };
        System.out.println("\nOriginal Color Array:");
        printArray(colors);

        bubbleSort(colors, Comparator.reverseOrder()); // Using Comparator
        System.out.println("\nSorted Color Array (Comparator - Reverse Order):");
        printArray(colors);
    }

    /**
     * Generic Bubble Sort using Comparable interface.
     * This method requires the elements to implement Comparable<E>.
     */
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean swapped;
        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.length - i - 1; j++) {
                // Compare adjacent elements using compareTo
                if (list[j].compareTo(list[j + 1]) > 0) {
                    // Swap elements
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no swaps occurred, array is already sorted
            if (!swapped) break;
        }
    }

    /**
     * Generic Bubble Sort using Comparator interface.
     * This allows sorting based on a custom comparison rule.
     */
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean swapped;
        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.length - i - 1; j++) {
                // Compare using provided Comparator
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    // Swap elements
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no swaps occurred, array is already sorted
            if (!swapped) break;
        }
    }

    /**
     * Utility method to print array contents.
     */
    public static <E> void printArray(E[] array) {
        System.out.print("[ ");
        for (E element : array) {
            System.out.print(element + " ");
        }
        System.out.println("]");
    }
}
