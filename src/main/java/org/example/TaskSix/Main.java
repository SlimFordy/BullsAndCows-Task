package org.example.TaskSix;

import org.example.OutputStreamListener;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        // Ask user for input method
        System.out.println("Do you wish to:");
        System.out.println("1. Enter guesses manually");
        System.out.println("2. Load guesses from a file");
        System.out.print("Enter your choice (1 or 2): ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice == 1) {
            System.out.println("Manual input mode selected. Enter your 4-digit guesses:");
            org.example.TaskFour.EntryPoint.main(null);

        } else {
            // File input mode
            System.out.println("File input mode selected.");

            File file = null;
            boolean validFile = false;

            while (!validFile) {
                System.out.print("Enter filename: ");
                String filename = scanner.nextLine();
                file = new File(filename);

                if (file.exists()) {
                    validFile = true;
                    System.out.println("File found! Reading guesses from " + filename);
                } else {
                    System.out.println("File not found. Please enter a valid filename.");
                }
            }

            // Now read and process the file
            try (Scanner fileScanner = new Scanner(file)) {
                List<String> guesses = new ArrayList<>();
                while (fileScanner.hasNextLine()) {
                    guesses.add(fileScanner.nextLine().trim());
                }
                org.example.TaskFour.EntryPoint.main(guesses.toArray(new String[0]));
            } catch (FileNotFoundException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }

        }
    }
}
