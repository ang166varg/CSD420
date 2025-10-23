/*
 * CSD420 Angela Vargas 2.2 Programming Assignment
 * This program generates and stores random integers and doubles in a file.
 * If the file doesn't exist, it will be created. If it exists, the data will be appended.
 */

import java.io.*;
import java.util.Random;

public class Vargas_DataWriter {
    public static void main(String[] args) {
        System.out.println("=== Random Data Writer ===");
        System.out.println("This program creates or appends random numbers to 'AngelaVargas_datafile.dat'.\n");

        // File to write to
        String fileName = "AngelaVargas_datafile.dat";

        try (PrintWriter output = new PrintWriter(new FileOutputStream(fileName, true))) {
            Random rand = new Random();

            // Generate and write five random integers
            output.println("Random Integers:");
            for (int i = 0; i < 5; i++) {
                int randomInt = rand.nextInt(100); // random integer between 0–99
                output.print(randomInt + " ");
            }
            output.println(); // new line

            // Generate and write five random doubles
            output.println("Random Doubles:");
            for (int i = 0; i < 5; i++) {
                double randomDouble = rand.nextDouble() * 100; // random double between 0–99.99
                output.printf("%.2f ", randomDouble);
            }
            output.println("\n"); // spacing between sets

            System.out.println("Data successfully written to " + fileName);

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
