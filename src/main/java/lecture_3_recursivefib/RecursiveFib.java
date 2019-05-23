package lecture_3_recursivefib;

public class RecursiveFib {
	public int fib(int n) {
		System.out.println("Call to fib at " + n);
		if(n < 0) return -1;
		if(n==0 || n == 1) return n;
		return fib(n-1) + fib(n-2);
	}
	public static void main(String[] args) {
		RecursiveFib rf = new RecursiveFib();
		System.out.println(rf.fib(15));
	}
}
