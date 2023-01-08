package hexlet.code;

import java.util.Scanner;

class App {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        var choice = sc.next();

        switch (choice) {
            case "1" -> greetings(sc);
            case "2" -> Even.play(greetings(sc), sc);
        }
    }
    static String greetings(Scanner sc) {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");

        var name = sc.next();
        System.out.printf("Hello, %s!%n", name);

        return name;
    }
}
