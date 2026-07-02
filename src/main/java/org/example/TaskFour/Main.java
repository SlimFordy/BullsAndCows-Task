package org.example.TaskFour;

import org.example.*;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bulls & cows game result.");
        System.out.print("Your code: ");
        BullsCounter bullsCounter = new BullsCounter();
        CowsCounter cowsCounter = new CowsCounter();
        boolean playerWon = false;
        boolean computerWon = false;

        Singleton.getTwoPlayerInstance(
                ValidFourDigitGenerator.getValidInputNumber()); //the secret code of computer is just generated inside

        int turn = 1;
        String playerGuessNumber;

        String computerGuessNumber;
        int bullsCount;
        int cowCount;
        Set<String> computerGuesses = new HashSet<>();
        do{
            System.out.println("Turn " + turn);
            playerGuessNumber = args == null ? ValidFourDigitGenerator.getValidInputNumber() : args[turn - 1];
            cowCount = cowsCounter.countCow(playerGuessNumber, true);
            bullsCount = bullsCounter.countBulls(playerGuessNumber, true);
            System.out.print(OutputFormatter.formatResult(true, playerGuessNumber,bullsCount, cowCount));
            if(bullsCount == 4){
                System.out.println("You win! :)");
                playerWon = true;
                break;
            }

            boolean isComputerChoiceValid;
            do {
                computerGuessNumber = ValidFourDigitGenerator.getValidFourDigitNumber();
                isComputerChoiceValid = computerGuesses.add(computerGuessNumber); // will return false if element already exist
            }while (!isComputerChoiceValid);

            cowCount = cowsCounter.countCow(computerGuessNumber, false);
            bullsCount = bullsCounter.countBulls(computerGuessNumber, false);
            System.out.println(OutputFormatter.formatResult(false, computerGuessNumber, bullsCount, cowCount));
            if(bullsCount == 4){
                System.out.println("Computer win! T_T");
                computerWon = true;
                break;
            }
            turn++;
        }while (turn <= 7);

        if(computerWon || playerWon)
            System.out.println("{ win!".replace("{", playerWon ? "You" : "Computer"));
        else System.out.println("Draw");
    }
}
