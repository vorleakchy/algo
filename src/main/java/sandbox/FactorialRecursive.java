package sandbox;

public class FactorialRecursive {
    public static int factorial(int n) {
        if (n == 0) return 1;
        System.out.println(n);
        return n * factorial(n - 1);
   }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
