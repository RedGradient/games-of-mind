package hexlet.code;

import java.util.Scanner;
import java.util.Random;

public class Even {
    public static void play(String username) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        Random rand = new Random();
        var answers = 0;
        var maxAnswersCount = 3;

        while (true) {
            var randomNumber = rand.nextInt(100);
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
            if (answers == maxAnswersCount) {
                System.out.println("Congratulations, " + username + "!");
                return;
            }

        }
    }
}
