package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;

public class Prime {
    private static final int RANDOM_NUMBER_RANGE = 100;

    private static boolean isPrime(int inputNumber) {

        if (inputNumber <= 1) {
            return false;
        }

        for (int i = 2; i <= inputNumber / 2; i++) {
            if ((inputNumber % i) == 0) {
                return false;
            }
        }

        return true;
    }

    private static HashMap<String, String> createRoundsData() {
        HashMap<String, String> roundsData = new HashMap<>();

        var randomNumber = Utils.RAND.nextInt(RANDOM_NUMBER_RANGE);
        var correctAnswer = isPrime(randomNumber) ? "yes" : "no";

        roundsData.put(Integer.toString(randomNumber), correctAnswer);

        return roundsData;
    }

    public static void play() {
        var description = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        HashMap<String, String> roundsData = new HashMap<>();
        for (var i = 0; i < Engine.MAX_ANSWERS_COUNT; i++) {
            HashMap<String, String> pair = createRoundsData();
            roundsData.putAll(pair);
        }

        Engine.run(description, roundsData);
    }
}
