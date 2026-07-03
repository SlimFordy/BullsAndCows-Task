package org.example;

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
