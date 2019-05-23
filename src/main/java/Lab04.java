import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Lab04 {
    /*
     * Problem 2: Generate random array
     */
    public static int[] randomArray(int n) {
        int[] arr = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int randomIndex = random.nextInt(n);
            swap(arr, i, randomIndex);
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
     * Problem 3: Goofy Sort
     */
    public static int[] goofySort(int[] arr) {
        while (!isSortedArray(arr)) {
//            System.out.println(Arrays.toString(arr));
            randomArray(arr);
        }

        return arr;
    }

    public static void randomArray(int[] arr) {
        Random random = new Random();
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            int randomIndex = random.nextInt(len);
            swap(arr, i, randomIndex);
        }
    }

    public static boolean isSortedArray(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]) return false;
        }

        return true;
    }

    /*
     * Problem 5: Sideway sort
     */
    public static int[] sidewaySort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int nextPos = minMaxPos(arr, i);
            swap(arr, i, nextPos);
        }

        return arr;
    }

    public static int minMaxPos(int[] arr, int i) {
        int index = i;
        int current = arr[i];
        boolean even = (index % 2) == 0;

        for (int j=i; j<arr.length; j++) {
            if (even && arr[j] < current) {
                current = arr[j];
                index = j;
            } else if (!even && arr[j] > current) {
                current = arr[j];
                index = j;
            }
        }

        return index;
    }


    /*
     * Problem 5: Sideway sort using Quick Sort
     */
    public static int[] sidewayQuickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);

        int[] newArr = new int[arr.length];
        int i = 0;
        int j = arr.length-1;
        int k = 0;

        while (i <= j) {
            newArr[k] = arr[i];
            i++;
            k++;
            newArr[k] = arr[j];
            j--;
            k++;
        }

        return newArr;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = arr[(left+right) / 2];
        int index = partition(arr, left, right, pivot);
        quickSort(arr, left, index - 1);
        quickSort(arr, index, right);
    }

    public static int partition(int[] arr, int left, int right, int pivot) {
        while (left <= right) {
            while(arr[left] < pivot) {
                left++;
            }

            while (arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        return left;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(randomArray(5)));

        System.out.println(Arrays.toString(goofySort(randomArray(5))));
    }
}
