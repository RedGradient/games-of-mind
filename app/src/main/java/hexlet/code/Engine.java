package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Engine {

    public static final Random RAND = new Random();
    public static final int MAX_ANSWERS_COUNT = 3;

    private static String askForName() {
        System.out.print("May I have your name? ");

        Scanner sc = new Scanner(System.in);
        var name = sc.next();
        sc.close();

        return name;
    }

    public static void run(String invitationQuestion, HashMap<String, String> questionAnswerPairs) {

        var username = askForName();

        System.out.println(invitationQuestion);

        for (Map.Entry<String, String> pair : questionAnswerPairs.entrySet()) {

            var question = pair.getKey();
            var correctAnswer = pair.getValue();

            System.out.println("Question: " + question);

            System.out.print("Your answer: ");
            Scanner sc = new Scanner(System.in);
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
