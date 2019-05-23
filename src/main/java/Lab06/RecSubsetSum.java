package Lab06;

import java.util.*;

public class RecSubsetSum {
    public static boolean recSubsetSum(int[] arr, int n, int sum) {
        if (sum == 0) return true;
        if (n < 0 || sum < 0) return false;

        boolean result1 = recSubsetSum(arr, n - 1, sum - arr[n]);
        boolean result2 = recSubsetSum(arr, n - 1, sum);

        return result1 || result2;
    }

    public static boolean recSubsetSumMemoized(int[] arr, int n, int sum, Map<String, Boolean> map) {
        if (sum == 0) return true;
        if (n < 0 || sum < 0) return false;

        String key = sum + "," + n;

        if (!map.containsKey(key)) {
            boolean result1 = recSubsetSumMemoized(arr, n - 1, sum - arr[n], map);
            boolean result2 = recSubsetSumMemoized(arr, n - 1, sum, map);

            map.put(key, result1 || result2);
        }

        return map.get(key);
    }

    public static void main(String[] args) {
//        int[] arr = {4,5,6};
//        int sum = 9;

        int[] arr = {7,3,2,5,8};
        int sum = 14;
        Map<String, Boolean> map = new HashMap<String, Boolean>();

        System.out.println(recSubsetSum(arr, arr.length - 1, sum));
        System.out.println(recSubsetSumMemoized(arr, arr.length - 1, sum, map));
    }
}
