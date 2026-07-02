package org.example;

import java.util.Random;

public class Singleton {
    
    public static Singleton instance;

    private final String computerSecretNumber;
    private final String playerSecretNumber;

    private Singleton(String secretNumber) {
        this.computerSecretNumber = secretNumber;
        this.playerSecretNumber = "";
    }

    public Singleton(String computerSecretNumber, String playerSecretNumber) {
        this.computerSecretNumber = computerSecretNumber;
        this.playerSecretNumber = playerSecretNumber;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton(ValidFourDigitGenerator.getValidFourDigitNumber());
        }
        return instance;
    }

    public static Singleton getInstance(String secretNumber) {
        if (instance == null) {
            instance = new Singleton(secretNumber);
        }
        return instance;
    }

    public static Singleton getTwoPlayerInstance(String playerSecretNumber){
        if(instance == null) {
            String computerSecretCode = "4281";
                    //ValidFourDigitGenerator.getValidFourDigitNumber();
            System.out.println("Computer's code: " + computerSecretCode);
            instance = new Singleton(computerSecretCode, playerSecretNumber);
        }
        return instance;
    }

    public String getComputerSecretNumber() {
        return computerSecretNumber;
    }

    public String getPlayerSecretNumber() {
        return playerSecretNumber;
    }
}
