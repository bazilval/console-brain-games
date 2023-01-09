package hexlet.code.games;

import java.util.Random;

public class Prime {
    private static final int BOUND = 500;
    private static String description = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static String[] questions;
    private static String[] answers;

    public static void writeData(Random rnd, int attempts) {
        questions = new String[attempts];
        answers = new String[attempts];

        for (int i = 0; i < attempts; i++) {
            int number = rnd.nextInt(BOUND);

            questions[i] = number + "";
            answers[i] = isPrime(number) ? "yes" : "no";
        }
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
