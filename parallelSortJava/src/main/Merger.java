package main;


public class Merger {

    public static void merge(int[] arr, int l1, int r1, int l2, int r2) {
        int leftCount = r1 - l1 + 1;
        int rightCount = r2 - l2 + 1;
        int[] data = new int[leftCount + rightCount];
        int pt = 0;

        int pt1 = l1;
        int pt2 = l2;

        while (pt1 <= r1 && pt2 <= r2) {
            if (arr[pt1] < arr[pt2]) {
                data[pt] = arr[pt1];
                pt1++;
            } else {
                data[pt] = arr[pt2];
                pt2++;
            }
            pt++;
        }

        while (pt1 <= r1) {
            data[pt] = arr[pt1];
            pt1++;
            pt++;
        }

        while (pt2 <= r2) {
            data[pt] = arr[pt2];
            pt2++;
            pt++;
        }

        for (int i = 0; i < data.length; i++) {
            arr[i + l1] = data[i];
        }
    }

}
