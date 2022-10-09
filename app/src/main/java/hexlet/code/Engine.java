package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Engine {

    public static final Random RAND = new Random();
    public static final int MAX_ANSWERS_COUNT = 3;

    private static String username;

    private static void askForName() {
        System.out.print("May I have your name? ");

        Scanner sc = new Scanner(System.in);
        var name = sc.next();

        System.out.println("Hello, " + name + "!");
        username = name;
    }

//    public static String askForStringInput() {
//        System.out.println("Your answer: ");
//        Scanner sc = new Scanner(System.in);
//        return sc.next();
//    }
//
//    public static int askForIntInput() {
//        System.out.println("Your answer: ");
//        Scanner sc = new Scanner(System.in);
//        return sc.nextInt();
//    }
//
//    public static void askQuestion(String question) {
//        System.out.println("Question: " + question);
//    }
//
//    public static boolean checkIfAnswerIsCorrect(String userAnswer, String correctAnswer) {
//        if (!userAnswer.equals(correctAnswer)) {
//            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", userAnswer, correctAnswer);
//            System.out.println("Let's try again, " + username + "!");
//            return false;
//        }
//        return true;
//    }
//
//    public static boolean checkIfAnswerIsCorrect(int userAnswer, int correctAnswer) {
//        if (userAnswer != correctAnswer) {
//            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", userAnswer, correctAnswer);
//            System.out.println("Let's try again, " + username + "!");
//            return false;
//        }
//        return true;
//    }

    public static void run(String invitationQuestion, HashMap<String, String> questionAnswerPairs) {

        askForName();

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
