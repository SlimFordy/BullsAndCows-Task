package org.example.TaskSeven;

import org.example.Configuration;
import org.example.OutputStreamListener;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ByteArrayOutputStream captureStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        // Create tee that writes to both console and capture stream
        OutputStreamListener tee = new OutputStreamListener(System.out, captureStream);
        PrintStream teePrintStream = new PrintStream(tee);
        System.setOut(teePrintStream);

        Scanner scanner = new Scanner(System.in);

        org.example.TaskSix.Main.main(null);

        byte[] totalOutput = captureStream.toString().getBytes();
        System.out.println("Save the output?(Y/N)");

        if(scanner.nextLine().equalsIgnoreCase("y"))
            try(FileOutputStream fos = new FileOutputStream("filelog.txt")) {
                fos.write(totalOutput);
                fos.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}
