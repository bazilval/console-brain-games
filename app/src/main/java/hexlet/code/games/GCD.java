package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    private static final int BOUND = 100;
    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public static void startGame() {
        int attempts = Engine.ATTEMPTS;
        var questionsAndAnswers = new String[attempts][];

        for (int i = 0; i < attempts; i++) {
            int numberOne = Utils.getRandom(BOUND);
            int numberTwo = Utils.getRandom(BOUND);

            var questionAndAnswer = new String[2];
            questionAndAnswer[0] = String.format("%d %d", numberOne, numberTwo);
            questionAndAnswer[1] = Integer.toString(gcd(numberOne, numberTwo));

            questionsAndAnswers[i] = questionAndAnswer;
        }

        Engine.play(DESCRIPTION, questionsAndAnswers);
    }
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
