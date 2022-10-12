package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;

public class Calculator {

    private static final String DESCRIPTION = "What is the result of the expression?";
    private static final int OPERAND_RANGE = 50;
    private static final char[] OPERATORS = {'+', '-', '*'};

    private static int calculateCorrectAnswer(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+' -> {
                return operand1 + operand2;
            }
            case '-' -> {
                return operand1 - operand2;
            }
            case '*' -> {
                return operand1 * operand2;
            }
            default -> {
                throw new Error("Unknown operator: '" + operator + "'");
            }
        }
    }

    private static void generateRoundData(HashMap<String, String> roundsData) {

        var operand1 = Utils.generateRandInt(OPERAND_RANGE);
        var operand2 = Utils.generateRandInt(OPERAND_RANGE);

        var operator = OPERATORS[Utils.generateRandInt(OPERATORS.length)];

        String question = operand1 + " " + operator + " " + operand2;
        int correctAnswer = calculateCorrectAnswer(operator, operand1, operand2);

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
