package hexlet.code.Games;

import hexlet.code.Engine;

import java.util.HashMap;

public class Calculator {


    private static final int OPERAND_RANGE = 50;
    private static final String[] OPERATORS = {"+", "-", "*"};

    private static HashMap<String, String> createQuestionAnswerPair() {
        HashMap<String, String> questionAnswerPair = new HashMap<>();

        var operand1 = Engine.RAND.nextInt(OPERAND_RANGE);
        var operand2 = Engine.RAND.nextInt(OPERAND_RANGE);

        var operator = OPERATORS[Engine.RAND.nextInt(OPERATORS.length)];

        String question = operand1 + " " + operator + " " + operand2;
        int correctAnswer;
        switch (operator) {
            case "+" -> {
                correctAnswer = operand1 + operand2;
            }
            case "-" -> {
                correctAnswer = operand1 - operand2;
            }
            case "*" -> {
                correctAnswer = operand1 * operand2;
            }
            default -> {
                correctAnswer = 0;
            }
        }

        questionAnswerPair.put(question, Integer.toString(correctAnswer));
        return questionAnswerPair;
    }

    public static void play() {
        var invitationQuestion = "What is the result of the expression?";

        HashMap<String, String> questionAnswerPairs = new HashMap<>();
        for (var i = 0; i < Engine.MAX_ANSWERS_COUNT; i++) {
            HashMap<String, String> pair = createQuestionAnswerPair();
            questionAnswerPairs.putAll(pair);
        }

        Engine.run(invitationQuestion, questionAnswerPairs);
    }
}
