package hexlet.code.Games;

import java.util.Scanner;

public class Cli {
    public static void greeting() {
        System.out.print("May I have your name? ");
        Scanner sc = new Scanner(System.in);
        var name = sc.next();
        System.out.println("Hello, " + name + "!");
    }
}
