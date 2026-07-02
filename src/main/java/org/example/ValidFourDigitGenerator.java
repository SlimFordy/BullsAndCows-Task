package org.example;

import java.util.*;

public class ValidFourDigitGenerator {

    public static String getValidFourDigitNumber(){
        Random random = new Random();
        StringBuilder secretCode = new StringBuilder();
        //build until secretCode contains 4 digits
        do {
            int digit = random.nextInt(0, 10);
            if (!secretCode.toString().contains(String.valueOf(digit)))
                secretCode.append(digit);

        } while (secretCode.length() != 4);
        return secretCode.toString();
    }

    public static String getValidInputNumber(){
        Scanner sc = new Scanner(System.in);
        String number = "";
        boolean isValid = false;
        String msg = "Invalid input. Enter a four digit unique integer";
        while (!isValid){
            try{
                number = sc.nextLine();
                int numberRepresentation = Integer.parseInt(number); //will throw InputMismatchException if not an integer
                if(number.length() != 4)
                    throw new IllegalArgumentException();

                //validate if unique ba ang each integer
                Set<Character> uniqueDigits = new HashSet<>();
                for (char c : number.toCharArray()) {
                    if (!uniqueDigits.add(c)) {
                        throw new IllegalArgumentException("Duplicate digit found: " + c);
                    }
                }

                isValid = true;
            }catch (InputMismatchException | IllegalArgumentException ignored){
                System.out.println(msg);
            }
        }

        return number;
    }
}
