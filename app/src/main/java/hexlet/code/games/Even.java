package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;

public class Even {

    private static final int RANDOM_NUMBER_RANGE = 100;

    private static HashMap<String, String> createRoundsData() {
        HashMap<String, String> roundsData = new HashMap<>();

        var randomNumber = Utils.RAND.nextInt(RANDOM_NUMBER_RANGE);
        var correctAnswer = (randomNumber % 2 == 0) ? "yes" : "no";

        roundsData.put(Integer.toString(randomNumber), correctAnswer);

        return roundsData;
    }

    public static void play() {
        var description = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        HashMap<String, String> roundsData = new HashMap<>();
        for (var i = 0; i < Engine.MAX_ANSWERS_COUNT; i++) {
            HashMap<String, String> pair = createRoundsData();
            roundsData.putAll(pair);
        }

        Engine.run(description, roundsData);
    }
}
