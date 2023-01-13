package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Even {
    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int BOUND = 1000;

    public static void startGame() {
        var attempts = Engine.ATTEMPTS;
        var rnd = new Random();
        var questionsAndAnswers = new String[attempts][];

        for (int i = 0; i < attempts; i++) {
            int number = rnd.nextInt(BOUND);
            var answer = isEven(number) ? "yes" : "no";

            var questionAndAnswer = new String[2];
            questionAndAnswer[0] = number + "";
            questionAndAnswer[1] = answer;

            questionsAndAnswers[i] = questionAndAnswer;
        }

        Engine.play(DESCRIPTION, questionsAndAnswers);
    }
    private static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
