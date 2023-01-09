package hexlet.code.games;

import java.util.Random;

public class Calculator {
    private static final int BOUND = 100;
    private static final String[] OPERATIONS = {"+", "-", "*"};
    private static String description = "What is the result of the expression?";
    private static String[] questions;
    private static String[] answers;

    public static void writeData(Random rnd, int attempts) {
        questions = new String[attempts];
        answers = new String[attempts];

        for (int i = 0; i < attempts; i++) {
            int numberOne = rnd.nextInt(BOUND);
            int numberTwo = rnd.nextInt(BOUND);
            String operation = OPERATIONS[rnd.nextInt(0, 2)];

            questions[i] = String.format("%d %s %d", numberOne, operation, numberTwo);
            switch (operation) {
                case "+" -> {
                    answers[i] = String.valueOf(numberOne + numberTwo);
                }
                case "-" -> {
                    answers[i] = String.valueOf(numberOne - numberTwo);
                }
                case "*" -> {
                    answers[i] = String.valueOf(numberOne * numberTwo);
                }
                default -> {
                }
            }
        }
    }
    public static String getDescription() {
        return description;
    }
    public static String[] getQuestions() {
        return questions;
    }
    public static String[] getAnswers() {
        return answers;
    }
}

