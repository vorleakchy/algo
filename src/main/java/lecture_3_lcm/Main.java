package lecture_3_lcm;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		List<Pair> input = new ArrayList<>();
		for(int i = 0; i < 4000; ++i) {
			Pair p = new Pair(i + 99, i + 234);
			input.add(p);
		}
		long start1 = System.currentTimeMillis();
		for(Pair p : input) {
			LcmSlow.lcm(p.first, p.second);
		}
		long end1 = System.currentTimeMillis();
		long start2 = System.currentTimeMillis();
		for(Pair p : input) {
			LcmFast.lcm(p.first, p.second);
		}
		long end2 = System.currentTimeMillis();
		
		System.out.println("Fast lcm: " + (end2 - start2));
		System.out.println("Slow lcm: " + (end1 - start1));
	}

}
