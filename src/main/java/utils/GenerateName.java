package utils;

import java.util.Random;

public class GenerateName {
    public static String generateName() {
        Random random = new Random();
        return "filter_" + ('a' + random.nextInt(26)) + random.nextInt(1000);
    }
}
