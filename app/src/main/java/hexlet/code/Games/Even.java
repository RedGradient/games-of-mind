package hexlet.code.Games;

import hexlet.code.Engine;

import java.util.HashMap;

public class Even {

    private static final int RANDOM_NUMBER_RANGE = 100;

    private static HashMap<String, String> createQuestionAnswerPair() {
        HashMap<String, String> questionAnswerPair = new HashMap<>();

        var randomNumber = Engine.RAND.nextInt(RANDOM_NUMBER_RANGE);
        var correctAnswer = (randomNumber % 2 == 0) ? "yes" : "no";

        questionAnswerPair.put(Integer.toString(randomNumber), correctAnswer);

        return questionAnswerPair;
    }

    public static void play() {
        var invitationQuestion = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        HashMap<String, String> questionAnswerPairs = new HashMap<>();
        for (var i = 0; i < Engine.MAX_ANSWERS_COUNT; i++) {
            HashMap<String, String> pair = createQuestionAnswerPair();
            questionAnswerPairs.putAll(pair);
        }

        Engine.run(invitationQuestion, questionAnswerPairs);
    }
}
