package main;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int length = 1000000;
        int low = -10000;
        int high = 10000;
        int partNum = 16;

        int[] arr = ArrayGenerator.gen(length, low, high);
//        int[] arr2 = arr.clone();

//        long start = System.currentTimeMillis();

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

//        long end1 = System.currentTimeMillis();
//
//        Arrays.sort(arr2);
//
//        long end2 = System.currentTimeMillis();
//
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.equals(arr, arr2));
//        System.out.println("1: " + (end1 - start));
//        System.out.println("2: " + (end2 - end1));

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                System.out.println("error");
            }
        }

        System.out.println(true);

    }
}
