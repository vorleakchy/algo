package sandbox;

public class Factorial {
    public static int factorial(int n) {
        if (n == 0) return 1;

        int accum = 1;

        for (int i=1; i<=n; i++) {
            accum *= i;
        }

        return accum;
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
