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

    public static void startGame() {
        var attempts = Engine.ATTEMPTS;
        var rnd = new Random();
        var questionsAndAnswers = new String[attempts][];

        for (int i = 0; i < attempts; i++) {
            var startNum = rnd.nextInt(NUM_BOUND);
            var delta = rnd.nextInt(DELTA_ORIGIN, DELTA_BOUND);
            var length = rnd.nextInt(LENGTH_ORIGIN, LENGTH_BOUND);
            var progression = getProgression(startNum, delta, length);
            var missingPos = rnd.nextInt(0, length - 1);

            questionsAndAnswers[i] = getQuestionAndAnswer(progression, missingPos);
        }

        Engine.play(DESCRIPTION, questionsAndAnswers);
    }
    private static int[] getProgression(int start, int delta, int length) {
        var result = new int[length];

        for (int i = 0; i < length; i++) {
            result[i] = start + delta * i;
        }
        return result;
    }
    private static String[] getQuestionAndAnswer(int[] progression, int missingPos) {
        var stringBuilder = new StringBuilder();
        String[] questionAndAnswer = new String[2];

        for (int i = 0; i < progression.length; i++) {
            var num = progression[i];
            stringBuilder.append(" ");
            if (i == missingPos) {
                questionAndAnswer[1] = num + "";
                stringBuilder.append("..");
            } else {
                stringBuilder.append(num);
            }
        }
        questionAndAnswer[0] = stringBuilder.toString().trim();

        return questionAndAnswer;
    }
}
