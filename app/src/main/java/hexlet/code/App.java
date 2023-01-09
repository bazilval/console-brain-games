package hexlet.code;

import java.util.Scanner;
import static java.lang.System.out;

class App {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
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
            case "1" -> Engine.greetings();
            case "2", "3", "4", "5", "6" -> Engine.play(choice);
            default -> {
            }
        }
    }
}
