package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Utils {
    private static final Random RAND = new Random();
    public static final Scanner SC = new Scanner(System.in);

    public static int generateRandInt(int max) {
        return RAND.nextInt(max);
    }

    public static int generateRandInt(int min, int max) {
        return RAND.nextInt(min, max);
    }
}
