package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int BOUND = 1000;

    public static void startGame() {
        int attempts = Engine.ATTEMPTS;
        var questionsAndAnswers = new String[attempts][];

        for (int i = 0; i < attempts; i++) {
            int number = Utils.getRandom(BOUND);
            var answer = isEven(number) ? "yes" : "no";

            var questionAndAnswer = new String[2];
            questionAndAnswer[0] = Integer.toString(number);
            questionAndAnswer[1] = answer;

            questionsAndAnswers[i] = questionAndAnswer;
        }

        Engine.play(DESCRIPTION, questionsAndAnswers);
    }
    private static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
