import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lab02A {
    public static int[] merge(int[] arr1, int[] arr2) {
        int n = arr1.length + arr2.length;
        int[] c = new int[n];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                c[k] = arr1[i];
                i++;
            } else {
                c[k] = arr2[j];
                j++;
            }

            k++;
        }

        while (i < arr1.length) {
            c[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            c[k] = arr2[j];
            j++;
            k++;
        }

        return c;
    }

    public static List<Integer> removeDups(List<Integer> l) {
        List<Integer> m = new ArrayList<Integer>();
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();

        for (int i=0; i<l.size()-1; i++) {
            if (!h.containsKey(l.get(i))) {
                h.put(l.get(i), 0);
                m.add(l.get(i));
            }
        }

        return m;
    }
}
