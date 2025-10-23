/*
 * CSD420 Angela Vargas 2.2 Programming Assignment
 * This program reads and displays the content from the file 'AngelaVargas_datafile.dat'.
 * It shows all random numbers previously stored by the DataWriter program.
 */

import java.io.*;

public class Vargas_DataReader {
    public static void main(String[] args) {
        System.out.println("=== Random Data Reader ===");
        System.out.println("This program reads and displays data from 'AngelaVargas_datafile.dat'.\n");

        String fileName = "AngelaVargas_datafile.dat";

        try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println("\nFile read successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please run Vargas_DataWriter first to create it.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
