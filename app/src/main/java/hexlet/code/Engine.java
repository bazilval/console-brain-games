package hexlet.code;

import java.util.Scanner;
import static java.lang.System.out;

public class Engine {
    public static final int ATTEMPTS = 3;

    public static void play(String description, String[] questions, String[] answers) {
        Scanner scanner = new Scanner(System.in);
        var username = greetings(scanner);

        out.println(description);

        for (int i = 0; i < ATTEMPTS; i++) {
            var question = questions[i];
            var answer = answers[i];

            out.printf("Question: %s%n", question);
            out.print("Your answer: ");
            var userAnswer = scanner.next();

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
    public static String greetings(Scanner sc) {
        out.println("\nWelcome to the Brain Games!");
        out.print("May I have your name? ");

        var username = sc.next();
        out.printf("Hello, %s!%n", username);

        return username;
    }
}
