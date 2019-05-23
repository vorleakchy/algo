package sandbox;

public class BinarySearch {
    public static boolean binarySearch(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == x) {
                return true;
            } else if (x < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 6, 7, 9};

        System.out.println(binarySearch(arr, 3));
        System.out.println(binarySearch(arr, 11));
    }
}
