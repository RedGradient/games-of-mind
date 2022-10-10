package hexlet.code.Games;

import hexlet.code.Engine;

import java.util.HashMap;

public class Progression {


    // min & max values for randomizers
    private static final int ARRAY_LENGTH_MIN = 5;
    private static final int ARRAY_LENGTH_MAX = 11;
    private static final int STEP_MIN = 1;
    private static final int STEP_MAX = 11;

    private static final int FIRST_ELEMENT_RANGE = 50;

    private static HashMap<String, String> createQuestionAnswerPair() {
        HashMap<String, String> questionAnswerPair = new HashMap<>();

        var arrayLength = Engine.RAND.nextInt(ARRAY_LENGTH_MIN, ARRAY_LENGTH_MAX);
        int[] progression = new int[arrayLength];
        var step = Engine.RAND.nextInt(STEP_MIN, STEP_MAX);

        var indexOfHiddenElement = Engine.RAND.nextInt(arrayLength);

        var firstElement = Engine.RAND.nextInt(FIRST_ELEMENT_RANGE);
        StringBuilder progressionBuilder = new StringBuilder(firstElement);
        progression[0] = firstElement;
        for (int i = 1; i < arrayLength; i++) {
            var value = progression[i - 1] + step;
            progression[i] = value;

            progressionBuilder.append(" ");
            progressionBuilder.append(value);
            if (i != arrayLength - 1) progressionBuilder.append(" ");
        }

        var correctAnswer = progression[indexOfHiddenElement];

        var progressionString = progressionBuilder.toString();
        var question = progressionString.replaceFirst(
                Integer.toString(progression[indexOfHiddenElement]),
                ".."
        );

        questionAnswerPair.put(question, Integer.toString(correctAnswer));

        return questionAnswerPair;
    }

    public static void play() {

        var invitationQuestion = "What number is missing in the progression?";

        HashMap<String, String> questionAnswerPairs = new HashMap<>();
        for (var i = 0; i < Engine.MAX_ANSWERS_COUNT; i++) {
            HashMap<String, String> pair = createQuestionAnswerPair();
            questionAnswerPairs.putAll(pair);
        }

        Engine.run(invitationQuestion, questionAnswerPairs);

    }

}
