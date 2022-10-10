package hexlet.code.Games;

import hexlet.code.Engine;

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

    private static HashMap<String, String> createQuestionAnswerPair() {
        HashMap<String, String> questionAnswerPair = new HashMap<>();

        var randomNumber = Engine.RAND.nextInt(RANDOM_NUMBER_RANGE);
        var correctAnswer = (isPrime(randomNumber)) ? "yes" : "no";

        questionAnswerPair.put(Integer.toString(randomNumber), correctAnswer);

        return questionAnswerPair;
    }

    public static void play() {
        var invitationQuestion = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        HashMap<String, String> questionAnswerPairs = new HashMap<>();
        for (var i = 0; i < Engine.MAX_ANSWERS_COUNT; i++) {
            HashMap<String, String> pair = createQuestionAnswerPair();
            questionAnswerPairs.putAll(pair);
        }

        Engine.run(invitationQuestion, questionAnswerPairs);
    }
}
