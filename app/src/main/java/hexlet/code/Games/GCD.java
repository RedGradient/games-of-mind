package hexlet.code.Games;

import hexlet.code.Engine;

import java.util.HashMap;

public class GCD {

    private static final int NUMBER_RANGE_MIN = 1;
    private static final int NUMBER_RANGE_MAX = 50;
    private static int getGCD(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (a % b == 0) {
            return b;
        }
        return getGCD(b, a % b);
    }

    public static HashMap<String, String> createQuestionAnswerPair() {
        HashMap<String, String> questionAnswerPair = new HashMap<>();

        var number1 = Engine.RAND.nextInt(NUMBER_RANGE_MIN, NUMBER_RANGE_MAX);
        var number2 = Engine.RAND.nextInt(NUMBER_RANGE_MIN, NUMBER_RANGE_MAX);

        var question = number1 + " " + number2;
        var correctAnswer = getGCD(Math.max(number1, number2), Math.min(number1, number2));

        questionAnswerPair.put(question, Integer.toString(correctAnswer));

        return questionAnswerPair;
    }
    public static void play() {
        var invitationQuestion = "Find the greatest common divisor of given numbers.";

        HashMap<String, String> questionAnswerPairs = new HashMap<>();
        for (var i = 0; i < Engine.MAX_ANSWERS_COUNT; i++) {
            HashMap<String, String> pair = createQuestionAnswerPair();
            questionAnswerPairs.putAll(pair);
        }

        Engine.run(invitationQuestion, questionAnswerPairs);
    }
}
