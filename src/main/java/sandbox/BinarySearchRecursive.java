package sandbox;

public class BinarySearchRecursive {
    public static boolean binarySearchRecursive(int[] arr, int x) {
        return binarySearchRecursive(arr, x, 0, arr.length - 1);
    }

    public static boolean binarySearchRecursive(int[] arr, int x, int left, int right) {
        if (left > right) {
            return false;
        }

        int mid = (left + right) / 2;

        if (x == arr[mid]) {
            return true;
        } else if (x < arr[mid]) {
            return binarySearchRecursive(arr, x, left, mid - 1);
        } else {
            return binarySearchRecursive(arr, x, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 6, 7, 9};

        System.out.println(binarySearchRecursive(arr, 3));
        System.out.println(binarySearchRecursive(arr, 11));
    }
}
