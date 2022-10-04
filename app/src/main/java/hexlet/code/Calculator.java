package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Calculator {
    public static void play(String username) {

        Random rand = new Random();
        var operandRange = 50;
        int answers = 0;

        while (true) {
            var operand1 = rand.nextInt(operandRange);
            var operand2 = rand.nextInt(operandRange);
            var operator = rand.nextInt(3);

            int correctAnswer = 0;
            int maxAnswersCount = 3;

            switch (operator) {
                case 0 -> {
                    correctAnswer = operand1 + operand2;
                    System.out.println("Question: " + operand1 + " + " + operand2);
                }
                case 1 -> {
                    correctAnswer = operand1 - operand2;
                    System.out.println("Question: " + operand1 + " - " + operand2);
                }
                case 2 -> {
                    correctAnswer = operand1 * operand2;
                    System.out.println("Question: " + operand1 + " * " + operand2);
                }
                default -> {}
            }

            Scanner sc = new Scanner(System.in);
            var input = sc.nextInt();

            System.out.println("Your answer: " + input);

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
