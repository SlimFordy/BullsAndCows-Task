package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BullsCounter {

    public int countBulls(String guessNumber, boolean isPlayerGuess){
        int currentOccurence = 0;
        String secretNumber = isPlayerGuess ?
                Singleton.getInstance().getComputerSecretNumber() :
                Singleton.getInstance().getPlayerSecretNumber();
        for(int i = 0; i < 4; i++){
            if(secretNumber.charAt(i) == guessNumber.charAt(i))
                currentOccurence++;
        }

        return currentOccurence;
    }
}
