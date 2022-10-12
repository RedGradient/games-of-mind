package hexlet.code;

import hexlet.code.games.Calculator;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

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
        var choice = Utils.SC.next();

        if (choice.equals("0")) {
            return;
        }

        System.out.println("\nWelcome to the Brain Games!");

        switch (choice) {
            case "1" -> Cli.greet();
            case "2" -> Even.play();
            case "3" -> Calculator.play();
            case "4" -> GCD.play();
            case "5" -> Progression.play();
            case "6" -> Prime.play();
            default -> System.out.println("Incorrect input\nPlease, enter number of the game listed above");
        }

        Utils.SC.close();
    }
}
