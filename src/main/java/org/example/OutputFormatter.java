package org.example;

public class OutputFormatter {

    public static String formatResult(boolean isPlayer, String guessNumber, int bullsCount, int cowCount){
        return "w guessed x, scoring y bull and z cows"
                .replace("w", isPlayer ? "You" : "Computer")
                .replace("x", guessNumber)
                .replace("y", String.valueOf(bullsCount))
                .replace("z", String.valueOf(cowCount));
    }
}
