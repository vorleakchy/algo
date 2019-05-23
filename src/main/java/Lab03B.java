public class Lab03B {
    public static boolean isPrime(int n) {
        if (n == 2) return true;
        if (n == 0 || n % 2 == 0) return false;
        if (n < 2) return false;

        for (int i=3; i<Math.sqrt(n); i=i+2) {
            if (n % i == 0) return false;
        }

        return true;
    }

    public static int fibIterative(int n) {
        if (n < 2) return n;

        int f1 = 0;
        int f2 = 1;
        int f = 0;

        for (int i=2; i<=n; i++) {
            f = f1 + f2;
            f1 = f2;
            f2 = f;
        }

        return f;
    }

    public static int fibRecursive(int n) {
        return fibRecursive(n, new int[n+1]);
    }

    public static int fibRecursive(int n, int[] memo) {
        if (n <=0) return 0;
        if (n == 1) return 1;
        if (memo[n] != 0) return memo[n];

        int f = fibRecursive(n-1, memo) + fibRecursive(n-2, memo);
        memo[n] = f;

        return f;
    }

    public static int kSmallest(int[] arr, int k) {
        for (int i=0; i<k; i++) {
            int nextPos = minPos(arr, i);
            swap(arr, i, nextPos);
        }

        return arr[k-1];
    }

    public static int minPos(int[] arr, int i) {
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

    public static int gcd(int m, int n) {
        if (n == 0) return m;
        return gcd(n, m % n);
    }

    public static boolean isGCDFormWithGiven(int m, int n) {
        int gcd = gcd(m, n);

        if (gcd % 2 != 0) return false;

        int k = 0;
        int temp = gcd;
        while (temp % 2 == 0) {
            temp /= 2;
            k++;
        }

        int p = gcd / (int)Math.pow(2, k);

        return isPrime(p);
    }
}