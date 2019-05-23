package sandbox;

import java.util.Arrays;

public class Fibonacci {
    public static int fib(int n) {
        System.out.println(n);
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
    }
}
