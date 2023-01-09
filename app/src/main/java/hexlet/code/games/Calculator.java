package hexlet.code.games;

import java.util.Random;

public class Calculator {
    private static final int BOUND = 100;
    private static final String[] OPERATIONS = {"+", "-", "*"};
    public static String description = "What is the result of the expression?";
    public static String[] questions = new String[3];
    public static String[] answers = new String[3];

    public static void writeData(Random rnd) {
        for (int i = 0; i < 3; i++) {
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
}

