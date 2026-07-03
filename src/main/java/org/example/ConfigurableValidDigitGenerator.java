package org.example;

import java.util.*;

public class ConfigurableValidDigitGenerator {

    public static String getValidFourDigitNumber(){
        Random random = new Random();
        StringBuilder secretCode = new StringBuilder();
        List<String> valuesChoices = getCombinationChoices();
        do {
            String digit = valuesChoices.get(random.nextInt(0, valuesChoices.size()));
            if (!secretCode.toString().contains(digit))
                secretCode.append(digit);

        } while (secretCode.length() != Configuration.getInstance().getMaxSecretCodeLength());
        return secretCode.toString();
    }

    public static String getValidInputNumber(){
        Scanner sc = new Scanner(System.in);
        String number = "";
        boolean isValid = false;
        List<String> validCombinationElements = getCombinationChoices();
        int inputLength = Configuration.getInstance().getMaxSecretCodeLength();
        String msg = "Invalid input. Enter a { digit unique integer".replace("{", inputLength + "");
        while (!isValid){
            try{
                number = sc.nextLine().toUpperCase().trim();
                if(number.length() != inputLength)
                    throw new IllegalArgumentException(msg);

                //validate if used with unique combinations and if element is allowed
                Set<Character> uniqueDigits = new HashSet<>();
                for (char c : number.toCharArray()) {
                    if (!uniqueDigits.add(c))
                        throw new IllegalArgumentException("Duplicate digit found: " + c);

                    if (!validCombinationElements.contains(Character.toString(c))) {
                        throw new IllegalArgumentException(
                                "Element " + c + " is not within the allowed choices."
                        );
                    }
                }

                isValid = true;
            }catch (InputMismatchException | IllegalArgumentException m){
                System.out.println(m.getMessage());
            }
        }

        return number;
    }

    private static List<String> getCombinationChoices(){
        List<String> valuesChoices = new ArrayList<>();
        for(int i = 0; i <10; i++){
            valuesChoices.add(String.valueOf(i));
        }
        if(Configuration.getInstance().isAreLettersAllowed()){
            for(int i = 65; i <= (int) Configuration.getInstance().getMaxCharAllowed(); i++) { //65 = A
                valuesChoices.add(Character.toString((char) i));
            }
        }

        return valuesChoices;
    }
}
