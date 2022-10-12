package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;

public class Progression {


    // min & max values for randomizers
    private static final int ARRAY_LENGTH_MIN = 5;
    private static final int ARRAY_LENGTH_MAX = 11;
    private static final int STEP_MIN = 1;
    private static final int STEP_MAX = 11;

    private static final int FIRST_ELEMENT_RANGE = 50;

    private static void generateRoundData(HashMap<String, String> roundsData) {

        var arrayLength = Utils.RAND.nextInt(ARRAY_LENGTH_MIN, ARRAY_LENGTH_MAX);
        var step = Utils.RAND.nextInt(STEP_MIN, STEP_MAX);

        int[] progression = new int[arrayLength];

        var indexOfHiddenElement = Utils.RAND.nextInt(arrayLength);

        var firstElement = Utils.RAND.nextInt(FIRST_ELEMENT_RANGE);
        StringBuilder progressionBuilder = new StringBuilder(Integer.toString(firstElement));
        progression[0] = firstElement;
        for (int i = 1; i < arrayLength; i++) {
            var value = progression[i - 1] + step;
            progression[i] = value;

            progressionBuilder.append(" ");
            progressionBuilder.append(value);
        }

        var correctAnswer = progression[indexOfHiddenElement];

        var progressionString = progressionBuilder.toString();
        var question = progressionString.replaceFirst(
                Integer.toString(progression[indexOfHiddenElement]),
                ".."
        );

        roundsData.put(question, Integer.toString(correctAnswer));
    }

    public static void play() {

        var description = "What number is missing in the progression?";

        HashMap<String, String> roundsData = new HashMap<>();
        for (var i = 0; i < Engine.MAX_ANSWERS_COUNT; i++) {
            generateRoundData(roundsData);
        }

        Engine.run(description, roundsData);

    }

}
