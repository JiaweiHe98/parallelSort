package main;

import java.util.Random;

public class ArrayGenerator {

    public static int[] gen(int length, int low, int high) {
        Random rand = new Random();
        int[] output = new int[length];

        for (int i = 0; i < length; i++) {
            output[i] = rand.nextInt(high - low) + low;
        }

        return output;
    }

}
