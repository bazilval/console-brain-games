package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Even {
    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int BOUND = 1000;

    public static void init(Random rnd, int attempts) {
        var questions = new String[attempts];
        var answers = new String[attempts];

        for (int i = 0; i < attempts; i++) {
            int number = rnd.nextInt(BOUND);
            var answer = isEven(number) ? "yes" : "no";

            questions[i] = number + "";
            answers[i] = answer;
        }

        Engine.play(DESCRIPTION, questions, answers);
    }
    private static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
