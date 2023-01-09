package hexlet.code.games;

import java.util.Random;

public class GCD {
    private static final int BOUND = 100;
    public static String description = "Find the greatest common divisor of given numbers.";
    public static String[] questions = new String[3];
    public static String[] answers = new String[3];

    public static void writeData(Random rnd) {
        for (int i = 0; i < 3; i++) {
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
}
