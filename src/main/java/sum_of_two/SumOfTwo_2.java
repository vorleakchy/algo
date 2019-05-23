package sum_of_two;

import java.util.HashMap;

public class SumOfTwo_2 {
	public static boolean sumExists(int[] arr, int z) {
		final Integer ONE = new Integer(1);
		HashMap<Integer, Integer> h = new HashMap<>();
		for(int i = 0; i < arr.length; ++i) {
			h.put(z - arr[i], ONE);
		}
		for(int j = 0; j < arr.length; ++j) {
			if(h.containsKey(arr[j]) && arr[j] != (z-arr[j])) {				
				return true;
			}
		}
		return false;
	}
	
	/*
	 * System.out.println("values found: " 
			      + arr[j] + ", " + (z-arr[j]));
	 */
}
