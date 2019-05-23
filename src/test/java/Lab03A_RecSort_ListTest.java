import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Lab03A_RecSort_ListTest {

    @Test
    void recSort() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(8);

        list.add(2);
        list.add(4);
        list.add(5);

        Assert.assertEquals("[1, 2, 3, 4, 5, 8]", ""+ Lab03A_RecSort_List.recSort(list));
    }

    @Test
    void partition() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(8);
        list.add(1);
        list.add(3);

        list.add(2);
        list.add(5);
        list.add(4);

        int mid = list.size() / 2;

        Assert.assertEquals("[8, 1, 3]", ""+ Lab03A_RecSort_List.partition(list, 0, mid));
        Assert.assertEquals("[2, 5, 4]", ""+ Lab03A_RecSort_List.partition(list, mid, list.size()));
    }

    @Test
    void merge() {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(3);
        list1.add(8);

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(2);
        list2.add(4);
        list2.add(5);

        Assert.assertEquals("[1, 2, 3, 4, 5, 8]", ""+ Lab03A_RecSort_List.merge(list1, list2));
    }
}