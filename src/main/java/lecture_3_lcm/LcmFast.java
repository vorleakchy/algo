package lecture_3_lcm;

public class LcmFast {
	
	public static int lcm(int x, int y) {
		int g = GCD.gcd(x, y);
		return (x * y)/g;
	}
	public static void main(String[] args) {
		System.out.println(lcm(4, 6));
		System.out.println(lcm(42, 48));
	}
}

//if(x < 1 || y < 1) throw new IllegalArgumentException("Both inputs must be positive");
