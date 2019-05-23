import java.util.Arrays;

public class Lab03A {
    public static int[] reverseOrder(int[] l) {
       return reverse(l, 0, l.length - 1);
    }

    public static int[] reverse(int[] l, int i, int j) {
        if (i >= j) {
            return l;
        } else {
            int temp = l[i];
            l[i] = l[j];
            l[j] = temp;
            i++;
            j--;

            return reverse(l, i, j);
        }
    }

    public static void main(String[] args) {
        int[] l1 = new int[]{ 8, 1, 3, 2, 5};
        int[] l2 = new int[]{ 8, 1, 3, 2};

        System.out.println(Arrays.toString(reverseOrder(l1)));
        System.out.println(Arrays.toString(reverseOrder(l2)));
    }
}
