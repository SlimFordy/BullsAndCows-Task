package org.example;

import org.example.TaskEight.ConfigurableSingleton;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BullsCounter {

    public int countBulls(String guessNumber, boolean isPlayerGuess){
        int currentOccurence = 0;
        String secretNumber = isPlayerGuess ?
                ConfigurableSingleton.getInstance().getComputerSecretNumber() :
                ConfigurableSingleton.getInstance().getPlayerSecretNumber();
        for(int i = 0; i < Configuration.getInstance().getMaxSecretCodeLength(); i++){
            if(secretNumber.charAt(i) == guessNumber.charAt(i))
                currentOccurence++;
        }

        return currentOccurence;
    }
}
