import java.util.*;

import lab1.powerset.PowerSet;

public class Lab01A {

    /*
     * Problem 1: Solution 1
     * Sum of two distinct numbers = z
     */
    public static boolean sumFound1(int[] arr, int z) {
        if (arr == null || arr.length < 2) {
            return false;
        }

        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (arr[i] != arr[j] && arr[i] + arr[j] == z) {
                    return true;
                }
            }
        }

        return false;
    }

    /*
     * Problem 1: Solution 2
     * Sum of two distinct numbers = z
     */
    public static boolean sumFound2(int[] arr, int z) {
        if (arr == null || arr.length < 2) {
            return false;
        }

        Set<Integer> hash = new HashSet<Integer>();

        for (int i=0; i<arr.length; i++) {
            if (hash.contains(arr[i])) {
                return false;
            }

            int sumMinus = z - arr[i];

            if (hash.contains(sumMinus)) {
                return true;
            }

            hash.add(arr[i]);
        }

        return false;
    }

    /*
     * Problem 2
     * Find the second smallest number in the array
     */
    public static int secondSmallest(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Input array too small");
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i=0; i<arr.length; i++) {
            if (arr[i] < first) {
                second = first;
                first = arr[i];
            } else if (arr[i] < second) {
                second = arr[i];
            }
        }

        return second;
    }

    /*
     * Problem 3
     * Sum of each set in the list
     */
    public static boolean sumFound(List<Integer> list, int k) {
        for (Set<Integer> set : PowerSet.powerSet(list)) {
            int sum = 0;

            for (Integer item : set) {
                sum += item;
            }

            if (sum == k) {
                return true;
            }
        }

        return false;
    }

    /*
     * Problem 4.A
     * Sort ArrayList using Selection Sort
     */
    public static void sort(ArrayList<Integer> list) {
        for (int i=0; i<list.size() - 1; i++) {
            int min = i;

            for (int j=i+1; j<list.size(); j++) {
                if (list.get(j) < list.get(min)) {
                    min = j;
                }
            }

            int temp = list.get(i);
            list.set(i, list.get(min));
            list.set(min, temp);
        }
    }

    /*
     * Problem 4.B
     * Sort LinkedList using Insertion Sort
     */
    public static void sort(LinkedList<Integer> list) {
        for (int i=1; i<list.size(); i++) {
            int ele = list.get(i);
            int j = i - 1;

            while (j>=0 && list.get(j) > ele) {
                list.set(j+1, list.get(j));
                j = j - 1;
            }

            list.set(j+1, ele);
        }
    }

    /*
     * Problem 5.A
     * Find element in array
     */
    public static boolean find(int[] arr, int z) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == z) {
                return true;
            }
        }

        return false;
    }

    /*
     * Problem 5.B
     * Find element in the sorted array
     */
    public static boolean findInSortedArray(int[] arr, int z) {
        int low = 0;
        int high = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > z) {
                high = mid - 1;
            } else if (arr[mid] < z) {
                low = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
