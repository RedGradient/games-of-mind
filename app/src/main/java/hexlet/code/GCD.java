package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class GCD {

    private static final int MAX_ANSWERS_COUNT = 3;

    private static final int NUMBER_RANGE = 50;
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

        while (true) {
            var number1 = rand.nextInt(NUMBER_RANGE);
            var number2 = rand.nextInt(NUMBER_RANGE);

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
            if (answers == MAX_ANSWERS_COUNT) {
                System.out.println("Congratulations, " + username + "!");
                return;
            }
        }
    }
}
