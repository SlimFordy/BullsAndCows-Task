package org.example.TaskTwo;

import org.example.BullsCounter;
import org.example.ConfigurableSingleton;
import org.example.ConfigurableValidDigitGenerator;
import org.example.CowsCounter;

public class Main {
    public static void main(String[] args) {
        ConfigurableSingleton.getInstance();
        CowsCounter cowsCounter = new CowsCounter();
        BullsCounter bullsCounter = new BullsCounter();
        int attempt = 1;
        int bulls = 0;
        do{
            String number = ConfigurableValidDigitGenerator.getValidInputNumber();

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