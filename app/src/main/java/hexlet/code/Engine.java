package hexlet.code;

import hexlet.code.games.Calculator;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;

import java.util.Random;
import java.util.Scanner;
import static java.lang.System.out;

public class Engine {
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
        switch (gameNum) {
            case "2": {
                Even.writeData(random);
                gameDescription = Even.description;
                questions = Even.questions;
                answers = Even.answers;
                break;
            }
            case "3": {
                Calculator.writeData(random);
                gameDescription = Calculator.description;
                questions = Calculator.questions;
                answers = Calculator.answers;
                break;
            }
            case "4": {
                GCD.writeData(random);
                gameDescription = GCD.description;
                questions = GCD.questions;
                answers = GCD.answers;
                break;
            }
            case "5": {
                Progression.writeData(random);
                gameDescription = Progression.description;
                questions = Progression.questions;
                answers = Progression.answers;
                break;
            }
            default: {
            }
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
