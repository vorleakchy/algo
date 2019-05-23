package Lab06;

public class Backpack {
    private static boolean validBackpackBruteForce(int items, int maxWeight, int minValue, int[] weights, int[] values) {
        for (int i = 0; i < items - 1; i++) {
            for (int j = i+1; j < items; j++) {
                if ((weights[i] + weights[j] <= maxWeight) && (values[i] + values[j] >= minValue))
                    return true;
            }
        }

        return false;
    }


//    public static boolean RecSubsetSum(int[] arr, int n, int sum) {
//        if (sum == 0) return true;
//        if (n < 0 || sum < 0) return false;
//
//        boolean include = RecSubsetSum(arr, n - 1, sum - arr[n]);
//        boolean exclude = RecSubsetSum(arr, n - 1, sum);
//
//        return include || exclude;
//    }


    private static boolean backpackRecursive(int items, int maxWeight, int minValue, int[] weights, int[] values) {
        if (maxWeight == 0 && minValue == 0) return true;
        if (items < 0 || (maxWeight < 0 && minValue < 0)) return false;

        boolean include = backpackRecursive(items - 1, maxWeight - weights[items], minValue - values[items], weights, values);
        boolean exclude = backpackRecursive(items - 1, maxWeight, minValue, weights, values);

        return include || exclude;
    }

    public static void main(String[] args) {
        int maxValue = 13;
        int maxWeight = 10;
        int[] values = {5, 10, 3, 2, 3};
        int[] weights = {4, 8, 3, 5, 2};
        int items = values.length;

//        System.out.println(validBackpackBruteForce(items, maxWeight, maxValue, weights, values));
        System.out.println(backpackRecursive(items-1, maxWeight, maxValue, weights, values));

    }
}
