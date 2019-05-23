package lecture_3_bin_search;
import java.util.*;

public class BinarySearchSlow {
	public static boolean binarySearch(List<? extends Comparable> list, Comparable z) {
		if(list.isEmpty()) return false;
		int mid = list.size()/2;
		Comparable x = list.get(mid);
		if(x.equals(z)) {
			return true;
		}
		if(z.compareTo(x) < 0) {
			return binarySearch(front(list, x), z);
		} else {  //z.compareTo(x) >  0
			return binarySearch(back(list, x), z);
		}
	}
	
	/**
	 * Returns a list containing all elements 
	 * @param list
	 * @return
	 */
	public static List<Comparable> front(List<? extends Comparable> list, Comparable x) {
		List<Comparable> retList = new ArrayList<>();
		for(Comparable ob : list) {
			if(ob.compareTo(x) < 0) {
				retList.add(ob);
			}
		}
		return retList;
		
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(4);
		list.add(6);
		list.add(8);
		System.out.println(BinarySearchSlow.binarySearch(list, 8));
		System.out.println(BinarySearchSlow.binarySearch(list, 7));
		
	}
	
	public static List<Comparable> back(List<? extends Comparable> list, Comparable x) {
		List<Comparable> retList = new ArrayList<>();
		for(Comparable ob : list) {
			if(ob.compareTo(x) > 0) {
				retList.add(ob);
			}
		}
		return retList;
		
	}
}
