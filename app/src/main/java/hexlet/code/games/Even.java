package hexlet.code.games;

import java.util.Random;

public class Even {
    public static String description = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int BOUND = 1000;
    public static String[] questions = new String[3];
    public static String[] answers = new String[3];

    public static void writeData(Random rnd) {
        for (int i = 0; i < 3; i++) {
            int number = rnd.nextInt(BOUND);
            var answer = number % 2 == 0 ? "yes" : "no";

            questions[i] = number + "";
            answers[i] = answer;
        }
    }
}
