package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a command");
        System.out.println("Valid commands are: ");
        String commandInput = scanner.nextLine().toLowerCase();
        System.out.println(commandInput);

    }
}
