package hexlet.code;

import hexlet.code.Games.Calculator;
import hexlet.code.Games.Cli;
import hexlet.code.Games.Even;
import hexlet.code.Games.GCD;
import hexlet.code.Games.Prime;
import hexlet.code.Games.Progression;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");

        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calculator");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");

        System.out.print("Your choice: ");
        Scanner sc = new Scanner(System.in);
        var choice = sc.next();
        sc.close();

        if (!choice.equals("0")) {
            System.out.println("\nWelcome to the Brain Games!");

            switch (choice) {
                case "1" -> Cli.greeting();
                case "2" -> Even.play();
                case "3" -> Calculator.play();
                case "4" -> GCD.play();
                case "5" -> Progression.play();
                case "6" -> Prime.play();
                default -> {

                }
            }
        }
    }
}
