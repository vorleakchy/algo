import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lab03A_RecSort_List {
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
    public static List<Integer> recSort(List<Integer> list) {
        List<Integer> list1;
        List<Integer> list2;
        int mid = (int)Math.ceil(list.size() / 2);

        if (list.size() > 1) {
            list1 = partition(list, 0, mid);
            list2 = partition(list, mid, list.size());

            list1 = recSort(list1);
            list2 = recSort(list2);

            list = merge(list1, list2);
        }

        return list;
    }

    public static List<Integer> partition(List<Integer> list, int start, int end) {
        List<Integer> partitionList = new ArrayList<Integer>();

        for (int i=start; i<end; i++) {
           partitionList.add(list.get(i));
        }

        return partitionList;
    }

    public static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> list = new ArrayList<Integer>();

        int i = 0;
        int j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
               list.add(list1.get(i));
               i++;
            } else {
               list.add(list2.get(j));
               j++;
            }
        }

        while (i < list1.size()) {
            list.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            list.add(list2.get(j));
            j++;
        }

        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(8);
        list.add(9);

        list.add(2);
        list.add(4);
        list.add(5);

        System.out.println("before "+list);

        System.out.println("after "+recSort(list));
    }
}
