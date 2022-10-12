package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;

public class Calculator {

    private static final int OPERAND_RANGE = 50;
    private static final char[] OPERATORS = {'+', '-', '*'};

    private static HashMap<String, String> createRoundsData() {
        HashMap<String, String> roundData = new HashMap<>();

        var operand1 = Utils.RAND.nextInt(OPERAND_RANGE);
        var operand2 = Utils.RAND.nextInt(OPERAND_RANGE);

        var operator = OPERATORS[Utils.RAND.nextInt(OPERATORS.length)];

        String question = operand1 + " " + operator + " " + operand2;
        int correctAnswer;
        switch (operator) {
            case '+' -> {
                correctAnswer = operand1 + operand2;
            }
            case '-' -> {
                correctAnswer = operand1 - operand2;
            }
            case '*' -> {
                correctAnswer = operand1 * operand2;
            }
            default -> {
                throw new Error("Unknown operator: '" + operator + "'");
            }
        }

        roundData.put(question, Integer.toString(correctAnswer));
        return roundData;
    }

    public static void play() {
        var description = "What is the result of the expression?";

        HashMap<String, String> roundsData = new HashMap<>();
        for (var i = 0; i < Engine.MAX_ANSWERS_COUNT; i++) {
            HashMap<String, String> roundData = createRoundsData();
            roundsData.putAll(roundData);
        }

        Engine.run(description, roundsData);
    }
}
