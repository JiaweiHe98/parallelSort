package main;

public class Sort implements Runnable {

    int[] arr;
    int start;
    int end;


    public Sort(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }


    public void sort(int l, int r) {
        if (l >= r) {
            return;
        }

        int pt = l - 1;
        for (int i = l; i < r; i++) {
            if (arr[i] < arr[r]) {
                pt++;
                swap(pt, i);
            }
        }
        pt++;
        swap(pt, r);

        sort(l, pt - 1);
        sort(pt + 1, r);

    }

    public void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public void run() {
        sort(start, end);
    }
}
