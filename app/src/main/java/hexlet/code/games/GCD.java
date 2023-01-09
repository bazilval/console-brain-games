package hexlet.code.games;

import java.util.Random;

public class GCD {
    private static final int BOUND = 100;
    private static String description = "Find the greatest common divisor of given numbers.";
    private static String[] questions;
    private static String[] answers;

    public static void writeData(Random rnd, int attempts) {
        questions = new String[attempts];
        answers = new String[attempts];

        for (int i = 0; i < attempts; i++) {
            int numberOne = rnd.nextInt(BOUND);
            int numberTwo = rnd.nextInt(BOUND);

            questions[i] = String.format("%d %d", numberOne, numberTwo);
            answers[i] = gcd(numberOne, numberTwo) + "";
        }
    }
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
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
