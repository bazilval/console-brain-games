package hexlet.code;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.Scanner;
import static java.lang.System.out;

public class Engine {
    public static final String[] GAMES_CLASSES = {"", "", "Even", "Calculator", "GCD", "Progression", "Prime"};
    public static Scanner scanner = App.scanner;
    public static Random random = new Random();
    public static String username;
    public static String gameDescription;
    public static String[] questions = new String[3];
    public static String[] answers = new String[3];

    public static void play(String gameNum) {
        greetings();
        getGameData(gameNum);
        out.println(gameDescription);

        boolean isRight;
        for (int i = 0; i < 3; i++) {
            isRight = askQuestion(i);
            if (!isRight) {
                return;
            }
        }
        out.printf("Congratulations, %s!%n", username);
    }
    public static void greetings() {
        out.println("\nWelcome to the Brain Games!");
        out.print("May I have your name? ");

        username = scanner.next();
        out.printf("Hello, %s!%n", username);
    }
    private static void getGameData(String gameNum) {
        var num = Integer.parseInt(gameNum);
        var gameClassName = GAMES_CLASSES[num];
        try {
            var gameClass = Class.forName("hexlet.code.games." + gameClassName);
            Method writeData = gameClass.getDeclaredMethod("writeData", random.getClass());
            writeData.invoke(null, random);

            Field descriptionField = gameClass.getField("description");
            gameDescription = (String) descriptionField.get(null);

            Field questionsField = gameClass.getField("questions");
            questions = (String[]) questionsField.get(null);

            Field answersField = gameClass.getField("answers");
            answers = (String[]) answersField.get(null);
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
