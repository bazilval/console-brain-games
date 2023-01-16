package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calculator {
    private static final String DESCRIPTION = "What is the result of the expression?";
    private static final int BOUND = 100;
    private static final String[] OPERATIONS = {"+", "-", "*"};

    public static void startGame() {
        int attempts = Engine.ATTEMPTS;
        var questionsAndAnswers = new String[attempts][];

        for (int i = 0; i < attempts; i++) {
            int numberOne = Utils.getRandom(BOUND);
            int numberTwo = Utils.getRandom(BOUND);
            String operation = OPERATIONS[Utils.getRandom(0, 2)];

            var questionAndAnswer = new String[2];
            questionAndAnswer[0] = String.format("%d %s %d", numberOne, operation, numberTwo);
            questionAndAnswer[1] = String.valueOf(calculate(numberOne, numberTwo, operation));

            questionsAndAnswers[i] = questionAndAnswer;
        }

        Engine.play(DESCRIPTION, questionsAndAnswers);
    }
    private static int calculate(int numberOne, int numberTwo, String operation) {
        int result = 0;

        switch (operation) {
            case "+" -> {
                result = numberOne + numberTwo;
            }
            case "-" -> {
                result = numberOne - numberTwo;
            }
            case "*" -> {
                result = numberOne * numberTwo;
            }
            default -> {
                System.out.println("Operation is not supported");
            }
        }

        return result;
    }
}

