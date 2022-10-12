package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;

public class GCD {

    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final int NUMBER_RANGE_MIN = 1;
    private static final int NUMBER_RANGE_MAX = 50;

    private static int calculateGCD(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (a % b == 0) {
            return b;
        }
        return calculateGCD(b, a % b);
    }

    public static void generateRoundData(HashMap<String, String> roundsData) {

        var number1 = Utils.generateRandInt(NUMBER_RANGE_MIN, NUMBER_RANGE_MAX);
        var number2 = Utils.generateRandInt(NUMBER_RANGE_MIN, NUMBER_RANGE_MAX);

        var question = number1 + " " + number2;
        var correctAnswer = calculateGCD(Math.max(number1, number2), Math.min(number1, number2));

        roundsData.put(question, Integer.toString(correctAnswer));
    }
    public static void play() {

        HashMap<String, String> roundsData = new HashMap<>();
        for (var i = 0; i < Engine.MAX_ANSWERS_COUNT; i++) {
            generateRoundData(roundsData);
        }

        Engine.run(DESCRIPTION, roundsData);
    }
}
