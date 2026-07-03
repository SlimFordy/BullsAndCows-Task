package org.example;

public class ConfigurableSingleton {

    public static ConfigurableSingleton instance;

    private final String computerSecretNumber;
    private final String playerSecretNumber;

    private ConfigurableSingleton(String secretNumber) {
        System.out.println(secretNumber);
        this.computerSecretNumber = secretNumber;
        this.playerSecretNumber = "";
    }

    public ConfigurableSingleton(String computerSecretNumber, String playerSecretNumber) {
        this.computerSecretNumber = computerSecretNumber;
        this.playerSecretNumber = playerSecretNumber;
    }

    public static ConfigurableSingleton getInstance() {
        if (instance == null) {
            instance = new ConfigurableSingleton(ConfigurableValidDigitGenerator.getValidFourDigitNumber());
        }
        return instance;
    }

    public static ConfigurableSingleton getInstance(String secretNumber) {
        if (instance == null) {
            instance = new ConfigurableSingleton(secretNumber);
        }
        return instance;
    }

    public static ConfigurableSingleton getTwoPlayerInstance(String playerSecretNumber){
        if(instance == null) {
            String computerSecretCode = ConfigurableValidDigitGenerator.getValidFourDigitNumber();
            System.out.println("Computer's code: " + computerSecretCode);
            instance = new ConfigurableSingleton(computerSecretCode, playerSecretNumber);
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
