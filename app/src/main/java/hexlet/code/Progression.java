package hexlet.code;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Progression {

    private static final int MAX_ANSWERS_COUNT = 3;

    // min & max values for randomizers
    private static final int ARRAY_LENGTH_MIN = 5;
    private static final int ARRAY_LENGTH_MAX = 11;
    private static final int STEP_MIN = 1;
    private static final int STEP_MAX = 11;

    private static final int FIRST_ELEMENT_RANGE = 50;

    public static void play(String username) {

        System.out.println("What number is missing in the progression?");

        Random rand = new Random();

        int answers = 0;

        while (true) {

            var arrayLength = rand.nextInt(ARRAY_LENGTH_MIN, ARRAY_LENGTH_MAX);
            int[] progression = new int[arrayLength];
            var step = rand.nextInt(STEP_MIN, STEP_MAX);

            var indexOfHiddenElement = rand.nextInt(arrayLength);

            progression[0] = rand.nextInt(FIRST_ELEMENT_RANGE);
            for (int i = 1; i < arrayLength; i++) {
                progression[i] = progression[i - 1] + step;
            }

            var correctAnswer = progression[indexOfHiddenElement];

            var progressionAsString = Arrays.toString(progression)
                    .replace("[", "")
                    .replace("]", "");
            var question = progressionAsString.replaceFirst(
                    Integer.toString(progression[indexOfHiddenElement]),
                    ".."
            );

            System.out.println("Question: " + question);

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
            if (answers == MAX_ANSWERS_COUNT) {
                System.out.println("Congratulations, " + username + "!");
                return;
            }
        }
    }

}
