package sandbox;

import java.util.Arrays;

public class MinSort {
    public static int[] sort(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            int nextPos = nextPos(arr, i);
            swap(arr, i, nextPos);
        }

        return arr;
    }

    public static int nextPos(int[] arr, int i) {
        int index = i;
        int min = arr[i];

        for (int j=i; j<arr.length; j++) {
            if (arr[j] < min) {
                min = arr[j];
                index = j;
            }
        }

        return index;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 2, 8, 1};
        System.out.println(Arrays.toString(sort(arr)));
    }
}
