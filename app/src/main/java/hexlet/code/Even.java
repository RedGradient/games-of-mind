package hexlet.code;

import java.util.Scanner;
import java.util.Random;

public class Even {

    private static final int MAX_ANSWERS_COUNT = 3;

    private static final int RANDOM_NUMBER_RANGE = 100;
    public static void play(String username) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        Random rand = new Random();
        var answers = 0;

        while (true) {
            var randomNumber = rand.nextInt(RANDOM_NUMBER_RANGE);
            var correctAnswer = (randomNumber % 2 == 0) ? "yes" : "no";

            System.out.println("Question: " + randomNumber);

            Scanner sc = new Scanner(System.in);
            var input = sc.next();

            System.out.println("Your answer: " + input);

            if (!input.equalsIgnoreCase(correctAnswer)) {
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
