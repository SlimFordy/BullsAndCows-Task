package org.example.TaskThree;

import org.example.*;

public class Main {
    public static void main(String[] args) {
        BullsCounter bullsCounter = new BullsCounter();
        CowsCounter cowsCounter = new CowsCounter();

        Singleton.getTwoPlayerInstance(
                ValidFourDigitGenerator.getValidInputNumber()); //the secret code of computer is just generated inside

        int turn = 1;
        String playerGuessNumber = null;
        String computerGuessNumber = null;
        int bullsCount = 0;
        int cowCount = 0;

        do{
            System.out.println("Turn " + turn);
            System.out.print("You guessed ");
            playerGuessNumber = ValidFourDigitGenerator.getValidInputNumber();
            cowCount = cowsCounter.countCow(playerGuessNumber, true);
            bullsCount = bullsCounter.countBulls(playerGuessNumber, true);
            System.out.println(OutputFormatter.formatResult(true, playerGuessNumber, bullsCount, cowCount));

            computerGuessNumber = ValidFourDigitGenerator.getValidFourDigitNumber();
            cowCount = cowsCounter.countCow(computerGuessNumber, false);
            bullsCount = bullsCounter.countBulls(computerGuessNumber, false);
            System.out.println(OutputFormatter.formatResult(false, computerGuessNumber, bullsCount, cowCount));
            turn++;
        }while (turn <= 7);
    }
}
