package org.example.TaskTwo;

import org.example.BullsCounter;
import org.example.CowsCounter;
import org.example.Singleton;

import java.util.Scanner;

public class AnotherMain {
    public static void main(String[] args) {
        Singleton.getInstance(args[0]);
        CowsCounter cowsCounter = new CowsCounter();
        BullsCounter bullsCounter = new BullsCounter();
        Scanner sc = new Scanner(System.in);
        int attempt = 1;
        int bulls = 0;
        do{
            String number = args[attempt];
            bulls = bullsCounter.countBulls(number, true);
            int cows = cowsCounter.countCow(number, true);
            attempt++;
            System.out.println("Result z: x bulls and y cows"
                    .replace("x",String.valueOf(bulls))
                    .replace("y", String.valueOf(cows))
                    .replace("z", String.valueOf(attempt - 1)));
        }while (attempt <= 6 && bulls < 4);

        if(bulls == 4) System.out.println("You win!");
        else System.out.println("No more attempt. Try again later");

    }
}
