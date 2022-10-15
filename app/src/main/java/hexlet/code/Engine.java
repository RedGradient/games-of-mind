package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Engine {

    public static final int MAX_ANSWERS_COUNT = 3;

    public static void run(String description, HashMap<String, String> roundsData) {

        System.out.print("May I have your name? ");

        Scanner sc = new Scanner(System.in);
        var username = sc.next();

        System.out.println("Hello, " + username + "!");

        System.out.println(description);

        for (Map.Entry<String, String> roundData : roundsData.entrySet()) {

            var question = roundData.getKey();
            var correctAnswer = roundData.getValue();

            System.out.println("Question: " + question);

            System.out.print("Your answer: ");
            var userInput = sc.next();

            if (!userInput.equals(correctAnswer)) {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", userInput, correctAnswer);
                System.out.println("Let's try again, " + username + "!");
                return;
            }

            System.out.println("Correct!");
        }

        System.out.println("Congratulations, " + username + "!");
    }

}
