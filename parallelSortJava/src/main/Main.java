package main;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int length = 10000;
        int low = -100;
        int high = 100;
        int partNum = 5;

        int[] arr = ArrayGenerator.gen(length, low, high);
        int[][] parts = Splitter.split(length, partNum);

        Thread[] threads = new Thread[partNum];

        for (int i = 0; i < partNum; i++) {
            int[] startEnd = parts[i];
            threads[i] = new Thread(new Sort(arr, startEnd[0], startEnd[1] - 1));
        }

        for (int i = 0; i < partNum; i++) {
            threads[i].start();
        }

        try {
            for (int i = 0; i < partNum; i++) {
                threads[i].join();
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

        for (int i = 1; i < partNum; i++) {
            Merger.merge(arr, 0, parts[i][0] - 1, parts[i][0], parts[i][1] - 1);
        }

        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                System.out.println("error");
            }
        }

    }
}
