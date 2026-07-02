package org.example.TaskThree;

import org.example.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bulls & cows game result.");
        System.out.print("Your code: ");
        BullsCounter bullsCounter = new BullsCounter();
        CowsCounter cowsCounter = new CowsCounter();

        Singleton.getTwoPlayerInstance(
                ValidFourDigitGenerator.getValidInputNumber()); //the secret code of computer is just generated inside

        int turn = 1;
        String playerGuessNumber;

        String computerGuessNumber;
        int bullsCount;
        int cowCount;

        boolean playerWon = false;
        boolean computerWon = false;

        do{
            System.out.println("Turn " + turn);
            playerGuessNumber = args.length == 0 ? ValidFourDigitGenerator.getValidInputNumber() : args[turn - 1];
            cowCount = cowsCounter.countCow(playerGuessNumber, true);
            bullsCount = bullsCounter.countBulls(playerGuessNumber, true);
            System.out.print(OutputFormatter.formatResult(true, playerGuessNumber,bullsCount, cowCount));
            if(bullsCount == 4){
                System.out.println("You win! :)");
                playerWon = true;
                break;
            }

            computerGuessNumber = ValidFourDigitGenerator.getValidFourDigitNumber();
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
