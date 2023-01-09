package hexlet.code;

import java.util.Scanner;

class Cli {
    public static void greetings() {
        var sc = new Scanner(System.in);

        System.out.print("May I have your name? ");
        var username = sc.next();
        System.out.println(String.format("Hello, %s!", username));
    }
}
