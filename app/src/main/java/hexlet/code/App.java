package hexlet.code;

import java.util.Scanner;

public class App {
    private static String askForName() {
        System.out.print("May I have your name? ");
        Scanner sc = new Scanner(System.in);
        var name = sc.next();
        System.out.println("Hello, " + name + "!");
        return name;
    }
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");

        System.out.println("0 - Exit");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calculator");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");

        System.out.print("Your choice: ");
        Scanner sc = new Scanner(System.in);
        var choice = sc.nextInt();

        System.out.println();

        if (choice != 0) {
            System.out.println("Welcome to the Brain Games!");

            switch (choice) {
                case 1 -> Cli.greeting();
                case 2 -> {
                    var name = askForName();
                    Even.play(name);
                }
                case 3 -> {
                    var name = askForName();
                    Calculator.play(name);
                }
                case 4 -> {
                    var name = askForName();
                    GCD.play(name);
                }
                case 5 -> {
                    var name = askForName();
                    Progression.play(name);
                }
            }
        }
    }
}
