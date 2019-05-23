package sandbox;

import java.util.Arrays;

public class FibonacciMemo {
    public static int fib(int n, int[] memo) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (memo[n] == 0){
            System.out.println(memo[n]);
            memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        }

        return memo[n];
    }

    public static void main(String[] args) {
        int[] a = new int[5];
        System.out.println(Arrays.toString(a));
        System.out.println(fib(5, new int[6]));
    }
}
