package org.example.TaskTwo;

import org.example.BullsCounter;
import org.example.CowsCounter;
import org.example.Singleton;
import org.example.ValidFourDigitGenerator;

public class Main {
    public static void main(String[] args) {
        Singleton.getInstance();
        CowsCounter cowsCounter = new CowsCounter();
        BullsCounter bullsCounter = new BullsCounter();
        int attempt = 1;
        int bulls = 0;
        do{
            String number = ValidFourDigitGenerator.getValidInputNumber();

            bulls = bullsCounter.countBulls(number, true);
            int cows = cowsCounter.countCow(number, true);
            System.out.println("Result z: x bulls and y cows"
                    .replace("x",String.valueOf(bulls))
                    .replace("y", String.valueOf(cows))
                    .replace("z", String.valueOf(attempt)));
            attempt++;
        }while (attempt <=7 && bulls < 4);

        if(bulls == 4) System.out.println("You win!");
        else System.out.println("No more attempt. Try again later");

    }
}