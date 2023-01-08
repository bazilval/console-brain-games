package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Even {
    public static void play(String name, Scanner sc) {
        boolean isRight;

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (int i = 0; i < 3; i++) {
            isRight = askQuestion(sc);
            if (!isRight) {
                System.out.printf("Let's try again, %s!%n", name);
                return;
            }
        }
        System.out.printf("Congratulations, %s!%n", name);
    }
    private static boolean askQuestion(Scanner sc) {
        var random = new Random();
        int number = random.nextInt(1000);
        var rightAnswer = number % 2 == 0 ? "yes" : "no";

        System.out.printf("Question: %s%n", number);
        System.out.print("Your answer: ");
        var answer = sc.next();
        var result = answer.equals(rightAnswer);

        if (result) {
            System.out.println("Correct!");
        } else {
            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", answer, rightAnswer);
        }

        return result;
    }
}
