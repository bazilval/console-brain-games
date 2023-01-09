package hexlet.code.games;

import java.util.Random;

public class Prime {
    private static final int BOUND = 500;
    public static String description = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static String[] questions = new String[3];
    public static String[] answers = new String[3];

    public static void writeData(Random rnd) {
        for (int i = 0; i < 3; i++) {
            int number = rnd.nextInt(BOUND);

            questions[i] = number + "";
            answers[i] = isPrime(number) ? "yes" : "no";
        }
    }
    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
