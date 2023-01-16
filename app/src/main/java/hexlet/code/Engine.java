package hexlet.code;

import static java.lang.System.out;

public class Engine {
    public static final int ATTEMPTS = 3;

    public static void play(String description, String[][] questionsAndAnswers) {
        String username = greetings();

        out.println(description);

        for (int i = 0; i < ATTEMPTS; i++) {
            String question = questionsAndAnswers[i][0];
            String answer = questionsAndAnswers[i][1];

            out.printf("Question: %s%n", question);
            String userAnswer = Utils.getInput("Your answer:");

            var isRight = userAnswer.equals(answer);
            if (isRight) {
                out.println("Correct!");
            } else {
                out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", userAnswer, answer);
                out.printf("Let's try again, %s!%n", username);
                return;
            }
        }
        out.printf("Congratulations, %s!%n", username);
    }
    public static String greetings() {
        out.println("\nWelcome to the Brain Games!");
        var username = Utils.getInput("May I have your name?");
        out.printf("Hello, %s!%n", username);

        return username;
    }
}
