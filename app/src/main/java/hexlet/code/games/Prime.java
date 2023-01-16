package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    private static final int BOUND = 500;
    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void startGame() {
        int attempts = Engine.ATTEMPTS;
        var questionsAndAnswers = new String[attempts][];

        for (int i = 0; i < attempts; i++) {
            int number = Utils.getRandom(BOUND);

            var questionAndAnswer = new String[2];
            questionAndAnswer[0] = Integer.toString(number);
            questionAndAnswer[1] = isPrime(number) ? "yes" : "no";

            questionsAndAnswers[i] = questionAndAnswer;
        }

        Engine.play(DESCRIPTION, questionsAndAnswers);
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
