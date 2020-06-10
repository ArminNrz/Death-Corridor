package main.math;

import java.util.Random;

public class MakeRandom {
    private static final Random randomGenerator = new Random();

    public static int randomInt(int rand){
        return randomGenerator.nextInt(rand);
    }

    public static Boolean randomBoolean() {
        return randomGenerator.nextBoolean();
    }
}
