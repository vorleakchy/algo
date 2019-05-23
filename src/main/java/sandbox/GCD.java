package sandbox;

public class GCD {
    public static int gcd(int m, int n) {
        if(m==0 && n == 0) throw new IllegalArgumentException("Inputs cannot both be zero");
        if(n==0) return m;
        System.out.println("m: " + m);
        System.out.println("n: " + n);
        return gcd(n, m % n);
    }

    public static void main(String[] args) {
        System.out.println(gcd(12, 8));
    }
}
