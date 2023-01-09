package hexlet.code.games;

import java.util.Random;
public class Progression {
    private static final int NUM_BOUND = 100;
    private static final int DELTA_BOUND = 10;
    public static String description = "What number is missing in the progression?";
    public static String[] questions = new String[3];
    public static String[] answers = new String[3];

    public static void writeData(Random rnd) {
        int startNum;
        int delta;
        int length;
        int missingPos;

        for (int i = 0; i < 3; i++) {
            startNum = rnd.nextInt(NUM_BOUND);
            delta = rnd.nextInt(2, DELTA_BOUND);
            length = rnd.nextInt(5, 10);
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
    }
}
