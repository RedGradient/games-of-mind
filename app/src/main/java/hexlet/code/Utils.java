package hexlet.code;

import java.util.Random;

public class Utils {
    private static final Random RAND = new Random();

    public static int generateRandInt(int max) {
        return RAND.nextInt(max);
    }

    public static int generateRandInt(int min, int max) {
        return RAND.nextInt(min, max);
    }
}
