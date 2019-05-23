package lecture_3_lcm;

public class GCD {
	/** Assumes m and n are nonnegative */
	static int gcd(int m, int n) {
		if(m==0 && n == 0) throw new IllegalArgumentException("Inputs cannot both be zero");
		if(n==0) return m;
		return gcd(n, m % n);
	}
	
}
