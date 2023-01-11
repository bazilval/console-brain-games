package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calculator;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;
import java.util.Random;
import java.util.Scanner;
import static java.lang.System.out;

class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int attempts = Engine.ATTEMPTS;

        out.println("Please enter the game number and press Enter.");
        out.println("1 - Greet");
        out.println("2 - Even");
        out.println("3 - Calculator");
        out.println("4 - GCD");
        out.println("5 - Progression");
        out.println("6 - Prime");
        out.println("0 - Exit");
        out.print("Your choice: ");
        var choice = scanner.next();

        switch (choice) {
            case "1" -> Engine.greetings(scanner);
            case "2" -> Even.init(random, attempts);
            case "3" -> Calculator.init(random, attempts);
            case "4" -> GCD.init(random, attempts);
            case "5" -> Progression.init(random, attempts);
            case "6" -> Prime.init(random, attempts);
            default -> {
            }
        }

        scanner.close();
    }
}
