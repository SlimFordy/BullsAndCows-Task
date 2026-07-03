package org.example.Singletons;

public class Configuration {

    public static Configuration instance;
    private int maximumAllowedTurns = 7;
    private int maxSecretCodeLength = 4;
    private boolean areLettersAllowed = false;
    private char maxCharAllowed = 'A';

    public static Configuration getInstance() {
        if(instance == null)
            instance = new Configuration();
        return instance;
    }

    public static void setInstance(Configuration instance) {
        Configuration.instance = instance;
    }

    public int getMaximumAllowedTurns() {
        return maximumAllowedTurns;
    }

    public void setMaximumAllowedTurns(int maximumAllowedTurns) {
        this.maximumAllowedTurns = maximumAllowedTurns;
    }

    public int getMaxSecretCodeLength() {
        return maxSecretCodeLength;
    }

    public void setMaxSecretCodeLength(int maxSecretCodeLength) {
        this.maxSecretCodeLength = maxSecretCodeLength;
    }

    public boolean isAreLettersAllowed() {
        return areLettersAllowed;
    }

    public void setAreLettersAllowed(boolean areLettersAllowed) {
        this.areLettersAllowed = areLettersAllowed;
    }

    public char getMaxCharAllowed() {
        return maxCharAllowed;
    }

    public void setMaxCharAllowed(char maxCharAllowed) {
        this.maxCharAllowed = maxCharAllowed;
    }
}
