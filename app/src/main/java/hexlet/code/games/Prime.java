package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Prime {
    private static final int BOUND = 500;
    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void init(Random rnd, int attempts) {
        var questions = new String[attempts];
        var answers = new String[attempts];

        for (int i = 0; i < attempts; i++) {
            int number = rnd.nextInt(BOUND);

            questions[i] = number + "";
            answers[i] = isPrime(number) ? "yes" : "no";
        }

        Engine.play(DESCRIPTION, questions, answers);
    }
    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
