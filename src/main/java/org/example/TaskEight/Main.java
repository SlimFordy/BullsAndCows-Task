package org.example.TaskEight;

import org.example.Singletons.Configuration;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        Configuration configuration = Configuration.getInstance();
        int numberOfConfigured;
        do{
            numberOfConfigured = 0;
            System.out.println("Do you want to configure the maximum number of turns (Default 7)? Y/N");
            if(sc.nextLine().equalsIgnoreCase("y")){
                configuration.setMaximumAllowedTurns(readInteger(sc));
                numberOfConfigured++;
            }

            System.out.println("Do you want to configure the maximum secret code length (Default 4)? Y/N");
            if(sc.nextLine().equalsIgnoreCase("Y")){
                configuration.setMaxSecretCodeLength(readInteger(sc));
                numberOfConfigured++;
            }

            if(numberOfConfigured < 2){
                System.out.println("Do you want to add letters to the combination choices? Y/N");
                if(sc.nextLine().equalsIgnoreCase("Y")){
                    configuration.setAreLettersAllowed(true);
                    configuration.setMaxCharAllowed(readLetter(sc));
                    numberOfConfigured++;
                }
            }

            if(numberOfConfigured < 2) System.out.println("Not configured enough. Configure again.");
        }while (numberOfConfigured < 2);

        org.example.TaskSeven.Main.main(null);
    }

    //ask for a number
    public static int readInteger(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    public static char readLetter(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.length() != 1) {
                System.out.println("Please enter exactly one letter.");
                continue;
            }

            char letter = input.charAt(0);

            if (!Character.isLetter(letter)) {
                System.out.println("Invalid input. Please enter a letter (A-Z or a-z).");
                continue;
            }
            return letter;
        }
    }
}
