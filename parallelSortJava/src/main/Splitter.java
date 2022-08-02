package main;

public class Splitter {

    public static int[][] split(int length, int parts) {
        int numPerPart = length / parts;
        int remaining = length % parts;
        int[][] output = new int[parts][2];
        int start = 0;

        for (int i = 0; i < parts - 1; i++) {
            output[i][0] = start;

            if (remaining > 0) {
                output[i][1] = start + numPerPart + 1;
                remaining--;

            } else {
                output[i][1] = start + numPerPart;
            }

            start = output[i][1];
        }

        output[parts - 1][0] = start;
        output[parts - 1][1] = length;

        return output;
    }

}
