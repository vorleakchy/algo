import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lab01B {

    /*
     * Math Problem 6
     * Return log base 2
     */
    public static double log2(double x) {
        return Math.log(x) / Math.log(2);
    }

    /*
     * Problem 6
     * Return another list that consists of all subsets of L (without duplicates)
     */
    public static List<Set<Integer>> powerSet(List<Integer> list) {
        List<Set<Integer>> listSet = new ArrayList<Set<Integer>>();
        HashSet<Integer> emptySet = new HashSet<Integer>();

        listSet.add(emptySet);

        for (int i=0; i<list.size()-1; i++) {
            for (int j=0; j<list.size(); j++) {
                Set<Integer> set = new HashSet<Integer>();
                set.add(list.get(i));
                listSet.add(set);
            }
        }

        return listSet;
    }

    /*
     * Problem 7
     * Generate Fibonacci numbers
     */
    public static int generate(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;

        return generate(n-1) + generate(n-2);
    }

    /*
     * Problem 8
     */
    public static int smallestCommon(int x, int y) {
        int gcd = 1;

        for (int i=1; i<=x && i<=y; i++) {
            if (x % i == 0 && y % i == 0) {
                gcd = i;
            }
        }

        return (x * y) / gcd;
    }
}
