package org.example.Utils;

public class OutputFormatter {

    public static String formatResult(boolean isPlayer, String guessNumber, int bullsCount, int cowCount){
        return "www guessed xx, scoring yy bull and zz cows\n"
                .replace("www", isPlayer ? "You" : "Computer")
                .replace("xx", guessNumber)
                .replace("yy", String.valueOf(bullsCount))
                .replace("zz", String.valueOf(cowCount));
    }
}
