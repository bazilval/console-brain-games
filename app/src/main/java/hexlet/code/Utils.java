package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Utils {
    private static final Random RANDOM = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);
    public static int getRandom(int lowBound, int upBound) {
        return RANDOM.nextInt(lowBound, upBound);
    }
    public static int getRandom(int upBound) {
        return RANDOM.nextInt(1, upBound);
    }
    public static String getInput(String message) {
        System.out.print(message + " ");
        return SCANNER.next();
    }
    public static void closeScanner() {
        SCANNER.close();
    }

}
