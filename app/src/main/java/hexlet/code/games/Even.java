package hexlet.code.games;

import java.util.Random;

public class Even {
    private static String description = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int BOUND = 1000;
    private static String[] questions;
    private static String[] answers;

    public static void writeData(Random rnd, int attempts) {
        questions = new String[attempts];
        answers = new String[attempts];

        for (int i = 0; i < attempts; i++) {
            int number = rnd.nextInt(BOUND);
            var answer = number % 2 == 0 ? "yes" : "no";

            questions[i] = number + "";
            answers[i] = answer;
        }
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
