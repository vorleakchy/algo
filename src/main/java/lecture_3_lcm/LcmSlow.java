package lecture_3_lcm;

public class LcmSlow {
	public static int lcm(int x, int y) {
		int m = Math.max(x, y);
		int current = x * y;
		for(int z = x * y; z >= m; z--) {
			if(divides(x, z) && divides(y, z)) {
				current = z;
			}
		}
		return current;
		
	}
	static boolean divides(int a, int b) {
		return a * (b/a) == b;
	}
	
	public static void main(String[] args) {
		System.out.println(lcm(4, 6));
		System.out.println(lcm(42, 48));
	}
}
