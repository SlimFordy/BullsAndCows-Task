package org.example.TaskFour;

import java.util.Scanner;

public class EntryPoint {
    public static void main(String[] args) {
        System.out.println(
                """
                ENTER 1 TO GO AGAINST EASY AI
                CLICK ANY KEY TO GO AGAINST MEDIUM AI
                """);
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        if(choice.equals("1"))
            org.example.TaskThree.Main.main(null);
        else
            org.example.TaskFour.Main.main(null);
    }
}
