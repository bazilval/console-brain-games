package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Calculator {
    private static final String DESCRIPTION = "What is the result of the expression?";
    private static final int BOUND = 100;
    private static final String[] OPERATIONS = {"+", "-", "*"};

    public static void init(Random rnd, int attempts) {
        var questions = new String[attempts];
        var answers = new String[attempts];

        for (int i = 0; i < attempts; i++) {
            int numberOne = rnd.nextInt(BOUND);
            int numberTwo = rnd.nextInt(BOUND);
            String operation = OPERATIONS[rnd.nextInt(0, 2)];

            questions[i] = String.format("%d %s %d", numberOne, operation, numberTwo);
            answers[i] = calculate(numberOne, numberTwo, operation);
        }

        Engine.play(DESCRIPTION, questions, answers);
    }
    private static String calculate(int numberOne, int numberTwo, String operation) {
        String result = "";

        switch (operation) {
            case "+" -> {
                result = String.valueOf(numberOne + numberTwo);
            }
            case "-" -> {
                result = String.valueOf(numberOne - numberTwo);
            }
            case "*" -> {
                result = String.valueOf(numberOne * numberTwo);
            }
            default -> {
            }
        }

        return result;
    }
}

