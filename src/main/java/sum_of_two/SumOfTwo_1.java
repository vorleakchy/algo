package sum_of_two;

/**
 * Note that since the inner for loop iterates below i each
 * time, no element of arr is used twice to arrive at a sum equal to z
 * @author pcorazza
 *
 */
public class SumOfTwo_1 {
	public static boolean sumExists(int[] arr, int z) {
		for(int i = 1; i < arr.length; ++i) {
			for(int j = 0; j < i; ++j) {
				if(arr[j] != arr[i] 
					&& arr[j] + arr[i] == z) 
					    return true;
			}
		}
		return false;
	}
}
