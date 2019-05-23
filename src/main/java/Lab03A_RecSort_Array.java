import java.lang.reflect.Array;
import java.util.Arrays;

public class Lab03A_RecSort_Array {
    /*
        Algorithm recSort(S)
        Input list L with n elements
        Output list L sorted
         if L.size() > 1 then
            (L1, L2) <- partition(L, n/2)
            recSort(L1)
            recSort(L2)
            L <- merge(L1, L2)
         return L
    */
    public static int[] recSort(int[] list) {

        if (list.length > 1) {
            int mid = list.length / 2;
            int[] list1 = new int[mid];
            int[] list2 = new int[list.length - mid];

            list1 = partition(list, 0, mid);
            list2 = partition(list, mid, list.length);

//            System.out.println("2before" + Arrays.toString(list2));
//            System.out.println(list2);
            list1 = recSort(list1);
            list2 = recSort(list2);

//            System.out.println("1" + Arrays.toString(list1));
//            System.out.println("2" + Arrays.toString(list2));

//            System.out.println(list2);
            list = merge(list1, list2);
//            System.out.println("l" + Arrays.toString(list));
        }

        return list;
    }

    public static int[] partition(int[] list, int start, int end) {
        int[] partitionList = new int[end-start];

        for (int i=start; i<end; i++) {
            partitionList[i-start] = list[i];
        }

        return partitionList;
    }

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

    public static void main(String[] args) {
        int[] list = new int[]{8, 9, 3, 1, 2, 5, 4};

        System.out.println("before "+ Arrays.toString(list));
        System.out.println("after "+ Arrays.toString(recSort(list)));
    }
}
