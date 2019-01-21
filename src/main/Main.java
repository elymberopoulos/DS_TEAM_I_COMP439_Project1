package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter a command");
            System.out.println("Valid commands are: exit, add device, dim device, turn on, turn off");
            String commandInput = scanner.nextLine().toLowerCase();
            System.out.println("The command input is: " + commandInput);
            switch(commandInput) {
                case "add device" :
                    System.out.println("ADD DEVICE TRIGGERED");
                    break; // optional

                case "exit" :
                    // Statements
                    break; // optional

                // You can have any number of case statements.
                default : // Optional
                    // Statements
            }
            if (commandInput.contentEquals("exit")) {
                break;
            }


        }while(true);
        System.exit(0);
    }
}
