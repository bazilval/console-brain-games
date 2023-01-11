package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Progression {
    private static final int NUM_BOUND = 100;
    private static final int DELTA_ORIGIN = 2;
    private static final int DELTA_BOUND = 10;
    private static final int LENGTH_ORIGIN = 5;
    private static final int LENGTH_BOUND = 10;
    private static final String DESCRIPTION = "What number is missing in the progression?";

    public static void init(Random rnd, int attempts) {
        int startNum;
        int delta;
        int length;
        int missingPos;
        var questions = new String[attempts];
        var answers = new String[attempts];

        for (int i = 0; i < attempts; i++) {
            startNum = rnd.nextInt(NUM_BOUND);
            delta = rnd.nextInt(DELTA_ORIGIN, DELTA_BOUND);
            length = rnd.nextInt(LENGTH_ORIGIN, LENGTH_BOUND);
            missingPos = rnd.nextInt(0, length - 1);

            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < length; j++) {
                int num = startNum + delta * j;
                stringBuilder.append(" ");
                if (j == missingPos) {
                    answers[i] = num + "";
                    stringBuilder.append("..");
                } else {
                    stringBuilder.append(num);
                }
            }

            questions[i] = stringBuilder.toString().trim();
        }

        Engine.play(DESCRIPTION, questions, answers);
    }
}
