package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Calculator {

    private static final int MAX_ANSWERS_COUNT = 3;

    private static final int OPERAND_RANGE = 50;
    private static final int OPERATOR_RANGE = 3;

    public static void play(String username) {

        System.out.println("What is the result of the expression?");

        Random rand = new Random();
        int answers = 0;

        while (true) {
            var operand1 = rand.nextInt(OPERAND_RANGE);
            var operand2 = rand.nextInt(OPERAND_RANGE);
            var operator = rand.nextInt(OPERATOR_RANGE);

            int correctAnswer = 0;

            String question = null;
            switch (operator) {
                case 0 -> {
                    correctAnswer = operand1 + operand2;
                    question = operand1 + " + " + operand2;
                }
                case 1 -> {
                    correctAnswer = operand1 - operand2;
                    question = operand1 + " - " + operand2;
                }
                case 2 -> {
                    correctAnswer = operand1 * operand2;
                    question = operand1 + " * " + operand2;
                }
            }
            System.out.println("Question: " + question);


            System.out.print("Your answer: ");
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
