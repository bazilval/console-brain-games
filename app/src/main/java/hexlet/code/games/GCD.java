package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class GCD {
    private static final int BOUND = 100;
    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public static void init(Random rnd, int attempts) {
        var questions = new String[attempts];
        var answers = new String[attempts];

        for (int i = 0; i < attempts; i++) {
            int numberOne = rnd.nextInt(BOUND);
            int numberTwo = rnd.nextInt(BOUND);

            questions[i] = String.format("%d %d", numberOne, numberTwo);
            answers[i] = gcd(numberOne, numberTwo) + "";
        }

        Engine.play(DESCRIPTION, questions, answers);
    }
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
