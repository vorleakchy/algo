package sum_of_two;

public class Main {

	public static void main(String[] args) {
		int[] test = {3, 7, 2, 4, 6, 11};
		int z = 13;
		System.out.println(testSlow(test,z));
		System.out.println(testFast(test, z));

	}
	
	public static boolean testSlow(int[] arr, int z) {
		return SumOfTwo_1.sumExists(arr, z);
	}
	
	public static boolean testFast(int[] arr, int z) {
		return SumOfTwo_2.sumExists(arr, z);
	}
	

}
