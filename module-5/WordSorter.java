// CSD420 Angela Vargas 5.2 Programming Assignment
// This program reads words from a text file named "collection_of_words.txt".
// It removes duplicate words and displays them in ascending (A–Z)
// and descending (Z–A) order. The program also explains what it’s doing
// in the console output for clarity.

import java.io.*;
import java.util.*;

public class WordSorter {
    public static void main(String[] args) {

        // Explain the purpose of the program to the user using this 
        System.out.println("This program reads words from 'collection_of_words.txt',");
        System.out.println("removes duplicate words, and displays them twice:");
        System.out.println("  1. In ascending alphabetical order (A → Z)");
        System.out.println("  2. In descending alphabetical order (Z → A)\n");

        // Use a TreeSet to automatically sort and store unique words
        Set<String> wordSet = new TreeSet<>();

        try {
            // Open and read from the specified file
            File file = new File("collection_of_words.txt");
            Scanner input = new Scanner(file);

            // Read each word, convert to lowercase, and remove punctuation
            while (input.hasNext()) {
                String word = input.next().toLowerCase().replaceAll("[^a-z]", "");
                if (!word.isEmpty()) {
                    wordSet.add(word); // TreeSet ensures uniqueness
                }
            }

            input.close();

            // Display words in ascending order
            System.out.println("Ascending Order (A to Z):");
            for (String word : wordSet) {
                System.out.println(word);
            }

            // Display words in descending order
            System.out.println("\nDescending Order (Z to A):");
            List<String> wordList = new ArrayList<>(wordSet);
            Collections.reverse(wordList);
            for (String word : wordList) {
                System.out.println(word);
            }

            // Final explanatory message
            System.out.println("\nProgram completed successfully.");
            System.out.println("All duplicate words were removed, and words were displayed in both orders.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: The file 'collection_of_words.txt' was not found.");
            System.out.println("Please ensure the file is located in the same directory as this program.");
        }
    }
}