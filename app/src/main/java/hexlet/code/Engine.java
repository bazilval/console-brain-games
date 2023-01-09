package hexlet.code;

import java.lang.reflect.Method;
import java.util.Random;
import java.util.Scanner;
import static java.lang.System.out;

public class Engine {
    private static final String[] GAMES_CLASSES = {"", "", "Even", "Calculator", "GCD", "Progression", "Prime"};
    private static Scanner scanner;
    private static Random random = new Random();
    private static String username;
    private static String gameDescription;
    private static final int ATTEMPTS = 3;
    private static String[] questions = new String[ATTEMPTS];
    private static String[] answers = new String[ATTEMPTS];

    public static void play(String gameNum, Scanner sc) {
        scanner = sc;
        greetings();
        getGameData(gameNum);
        out.println(gameDescription);

        boolean isRight;
        for (int i = 0; i < ATTEMPTS; i++) {
            isRight = askQuestion(i);
            if (!isRight) {
                return;
            }
        }
        out.printf("Congratulations, %s!%n", username);
    }
    public static void greetings(Scanner sc) {
        out.println("\nWelcome to the Brain Games!");
        out.print("May I have your name? ");

        username = sc.next();
        out.printf("Hello, %s!%n", username);
    }
    public static void greetings() {
        greetings(scanner);
    }
    private static void getGameData(String gameNum) {
        var num = Integer.parseInt(gameNum);
        var gameClassName = GAMES_CLASSES[num];
        try {
            var gameClass = Class.forName("hexlet.code.games." + gameClassName);
            Method writeData = gameClass.getDeclaredMethod("writeData", random.getClass(), int.class);
            writeData.invoke(null, random, ATTEMPTS);

            Method getDescription = gameClass.getDeclaredMethod("getDescription");
            gameDescription = (String) getDescription.invoke(null);

            Method getQuestions = gameClass.getDeclaredMethod("getQuestions");
            questions = (String[]) getQuestions.invoke(null);

            Method getAnswers = gameClass.getDeclaredMethod("getAnswers");
            answers = (String[]) getAnswers.invoke(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static boolean askQuestion(int questionNum) {
        var question = questions[questionNum];
        var answer = answers[questionNum];

        out.printf("Question: %s%n", question);
        out.print("Your answer: ");
        var userAnswer = scanner.next();
        var result = userAnswer.equals(answer);

        if (result) {
            out.println("Correct!");
        } else {
            out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", userAnswer, answer);
            out.printf("Let's try again, %s!%n", username);
        }

        return result;
    }

}
