package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;

public class Progression {

    private static final String DESCRIPTION = "What number is missing in the progression?";

    // min & max values for randomizers
    private static final int ARRAY_LENGTH_MIN = 5;
    private static final int ARRAY_LENGTH_MAX = 11;
    private static final int STEP_MIN = 1;
    private static final int STEP_MAX = 11;

    private static final int FIRST_ELEMENT_RANGE = 50;

    private static int[] generateProgression(int firstElement, int step, int length) {
        var progression = new int[length];
        progression[0] = firstElement;
        for (int i = 1; i < length; i++) {
            var value = progression[i - 1] + step;
            progression[i] = value;
        }

        return progression;
    }

    private static void generateRoundData(HashMap<String, String> roundsData) {

        var arrayLength = Utils.generateRandInt(ARRAY_LENGTH_MIN, ARRAY_LENGTH_MAX);
        var step = Utils.generateRandInt(STEP_MIN, STEP_MAX);
        var firstElement = Utils.generateRandInt(FIRST_ELEMENT_RANGE);

        int[] progression = generateProgression(firstElement, step, arrayLength);

        StringBuilder progressionBuilder = new StringBuilder(Integer.toString(firstElement));

        for (var i = 1; i < arrayLength; i++) {
            var value = progression[i];
            progressionBuilder.append(" ");
            progressionBuilder.append(value);
        }

        var indexOfHiddenNumber = Utils.generateRandInt(arrayLength);
        var hiddenNumber = progression[indexOfHiddenNumber];

        var progressionString = progressionBuilder.toString();
        var question = progressionString.replaceFirst(
                Integer.toString(hiddenNumber),
                ".."
        );

        roundsData.put(question, Integer.toString(hiddenNumber));
    }

    public static void play() {

        HashMap<String, String> roundsData = new HashMap<>();
        for (var i = 0; i < Engine.MAX_ANSWERS_COUNT; i++) {
            generateRoundData(roundsData);
        }

        Engine.run(DESCRIPTION, roundsData);

    }

}
