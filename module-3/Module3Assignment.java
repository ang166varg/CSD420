// Angela Vargas
// CSD420 3.2 Programming Assignment
// This program creates an ArrayList with 50 random numbers (1–20),
// removes duplicate values using a generic method, 
// and prints both the original and new lists.

import java.util.ArrayList;
import java.util.Random;

public class Module3Assignment {

    // Generic method to remove duplicates from an ArrayList
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> newList = new ArrayList<>();
        for (E element : list) {
            // Only add element if it's not already in newList
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }

    public static void main(String[] args) {
        // Create an ArrayList to hold 50 random integers between 1–20
        ArrayList<Integer> numbers = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 50; i++) {
            numbers.add(rand.nextInt(20) + 1); // Random number from 1–20
        }

        // Display the original ArrayList
        System.out.println("Original ArrayList (with duplicates):");
        System.out.println(numbers);

        // Call removeDuplicates method
        ArrayList<Integer> noDuplicates = removeDuplicates(numbers);

        // Display the new ArrayList without duplicates
        System.out.println("\nNew ArrayList (duplicates removed):");
        System.out.println(noDuplicates);
    }
}
