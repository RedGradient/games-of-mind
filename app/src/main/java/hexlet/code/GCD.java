package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class GCD {
    private static int getGCD(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (a % b == 0) {
            return b;
        }
        return getGCD(b, a % b);
    }

    public static void play(String username) {
        System.out.println("Find the greatest common divisor of given numbers.");

        Random rand = new Random();

        var answers = 0;
        var maxAnswersCount = 3;
        var rangeOfNumber = 50;

        while (true) {
            var number1 = rand.nextInt(rangeOfNumber);
            var number2 = rand.nextInt(rangeOfNumber);

            System.out.println("Question: " + number1 + " " + number2);
            var correctAnswer = getGCD(Math.max(number1, number2), Math.min(number1, number2));

            Scanner sc = new Scanner(System.in);
            var input = sc.nextInt();
            if (input != correctAnswer) {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", input, correctAnswer);
                System.out.println("Let's try again, " + username + "!");
                return;
            }
            answers++;
            System.out.println("Correct!");
            if (answers == maxAnswersCount) {
                System.out.println("Congratulations, " + username + "!");
                return;
            }
        }
    }
}