package lecture_1;

public class IterativeFactorial {
	public static void main(String[] args) {
		IterativeFactorial it = new IterativeFactorial();
		System.out.println(it.factorial(2));
		System.out.println(it.factorial(5));
	}
	
	//Assumes input is non-negative
	public long factorial(int n) {
		if(n == 0 ) {
			return 1;
		}
		long accum = 1L;
		for(int i = 1; i <= n; ++i) {
			accum *= i;
		}
		return accum;
	}
	
	
	
}
