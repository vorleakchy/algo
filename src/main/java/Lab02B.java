import java.util.Arrays;

public class Lab02B {
    static int[]  arr = new int[]{4, 3, 5, 1};

    /*
     * Problem 5.C
     * Best case of running time is O(n)
     */
    static void bubbleSort1(int[] arr) {
        int len = arr.length;
        boolean swapped;

        for (int i=0; i<len -1; i++) {
            swapped = false;

            for (int j=0; j<len-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(j, j+1);
                    swapped = true;
                }
            }

            if (swapped == false) {
                break;
            }
        }
    }

    static void bubbleSort(int[] arr) {
        int len = arr.length;

        for (int i=0; i<len -1; i++) {

            for (int j=0; j<len-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(j, j+1);
                }
            }
        }
    }

    static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String args[]) {
        bubbleSort1(arr);
        System.out.println(Arrays.toString(arr));
    }
}
