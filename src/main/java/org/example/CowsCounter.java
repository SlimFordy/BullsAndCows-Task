package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CowsCounter {

    /***
     * count how many digits does exist in the string
     * but are in different position
     */
    public int countCow(String number, boolean isPlayerGuess){
        Set<Integer> flaggedAsCowIndexes = new HashSet<>();
        List<Integer> secretCodeArray = new ArrayList<>();
        String secretNumber = isPlayerGuess ?
                Singleton.getInstance().getComputerSecretNumber() :
                Singleton.getInstance().getPlayerSecretNumber();

        for (char c : secretNumber.toCharArray()) {
            int num = Character.getNumericValue(c);
            secretCodeArray.add(num);
        }

        List<Integer> guessCodeArray = new ArrayList<>();

        for (char c : number.toCharArray()) {
            int num = Character.getNumericValue(c);
            guessCodeArray.add(num);
        }

        for(int i = 0; i < 4; i++){
            int secretNumberAtIndexI = secretCodeArray.get(i);

            for(int j = 0; j < 4; j++){
                int guessNumberAtIndexJ = guessCodeArray.get(j);
                boolean isPossibleCow = j != i && guessNumberAtIndexJ == secretNumberAtIndexI; // meaning same value, but different places
                if(isPossibleCow){
                    boolean isOppositeNotTheSame = secretCodeArray.get(j) != guessNumberAtIndexJ;
                    boolean indexIsIndexNotFlagged = !flaggedAsCowIndexes.contains(j);

                    if(isOppositeNotTheSame && indexIsIndexNotFlagged) {
                        flaggedAsCowIndexes.add(j);
                        break;
                    }
                }

            }
        }

        return flaggedAsCowIndexes.size();
    }
}
