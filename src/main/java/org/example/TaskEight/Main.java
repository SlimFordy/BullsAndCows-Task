package org.example.TaskEight;

import org.example.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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

        System.out.println("Bulls & cows game result.");
        System.out.print("Your code: ");
        BullsCounter bullsCounter = new BullsCounter();
        CowsCounter cowsCounter = new CowsCounter();

        ConfigurableSingleton.getTwoPlayerInstance(
                ConfigurableValidDigitGenerator.getValidInputNumber()); //the secret code of computer is just generated inside

        int turn = 1;
        String playerGuessNumber;

        String computerGuessNumber;
        int bullsCount;
        int cowCount;

        boolean playerWon = false;
        boolean computerWon = false;
        int maxLength = Configuration.getInstance().getMaxSecretCodeLength();
        int maxTurn = Configuration.getInstance().getMaximumAllowedTurns();

        do{
            System.out.println("Turn " + turn);
            playerGuessNumber = args.length == 0 ? ConfigurableValidDigitGenerator.getValidInputNumber() : args[turn - 1];
            cowCount = cowsCounter.countCow(playerGuessNumber, true);
            bullsCount = bullsCounter.countBulls(playerGuessNumber, true);
            System.out.print(OutputFormatter.formatResult(true, playerGuessNumber,bullsCount, cowCount));
            if(bullsCount == maxLength){
                System.out.println("You win! :)");
                playerWon = true;
                break;
            }

            computerGuessNumber = ConfigurableValidDigitGenerator.getValidFourDigitNumber();
            cowCount = cowsCounter.countCow(computerGuessNumber, false);
            bullsCount = bullsCounter.countBulls(computerGuessNumber, false);
            System.out.println(OutputFormatter.formatResult(false, computerGuessNumber, bullsCount, cowCount));
            if(bullsCount == maxLength){
                System.out.println("Computer win! T_T");
                computerWon = true;
                break;
            }
            turn++;
        }while (turn <= maxTurn);

        if(computerWon || playerWon)
            System.out.println("{ win!".replace("{", playerWon ? "You" : "Computer"));
        else System.out.println("Draw");
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
