import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Lab01ATest {

    @Test
    void sumFound1() {
        Assert.assertEquals(true, Lab01A.sumFound1(new int[]{1, 6, 2, 3}, 5));

        Assert.assertEquals(false, Lab01A.sumFound1(new int[]{3, 3, 4, 7}, 6));

        Assert.assertEquals(false, Lab01A.sumFound1(new int[]{1}, 2));
    }

    @Test
    void sumFound2() {
        Assert.assertEquals(true, Lab01A.sumFound2(new int[]{1, 4, 2, 3}, 5));

        Assert.assertEquals(false, Lab01A.sumFound2(new int[]{3, 3, 4, 7}, 6));

        Assert.assertEquals(false, Lab01A.sumFound2(new int[]{1}, 2));
    }

    @Test
    void secondSmallest() {
        Assert.assertEquals(2, Lab01A.secondSmallest(new int[]{1, 4, 2, 3}));

        Assert.assertEquals(3, Lab01A.secondSmallest(new int[]{3, 3, 4, 7}));

//        Assert.assertEquals(IllegalArgumentException.class, SecondSmallest.secondSmallest(new int[]{9}));
    }

    @Test
    void find() {
        Assert.assertEquals(true, Lab01A.find(new int[]{2, 8, 3, 4}, 3));

        Assert.assertEquals(false, Lab01A.find(new int[]{2, 8, 3, 4}, 5));

        Assert.assertEquals(true, Lab01A.find(new int[]{2, 3, 4, 8}, 3));

        Assert.assertEquals(false, Lab01A.find(new int[]{2, 3, 4, 8}, 5));
    }

    @Test
    void findInSortedArray() {
        Assert.assertEquals(true, Lab01A.find(new int[]{2}, 2));

        Assert.assertEquals(true, Lab01A.find(new int[]{2, 3}, 2));

        Assert.assertEquals(true, Lab01A.find(new int[]{2, 3, 4, 8}, 3));

        Assert.assertEquals(false, Lab01A.find(new int[]{2, 3, 4, 8}, 5));

        Assert.assertEquals(true, Lab01A.find(new int[]{2, 3, 4, 8, 9, 11, 15}, 15));
    }

    @Test
    void sort() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(7);
        list.add(5);
        list.add(4);
        list.add(2);

        Lab01A.sort(list);
        System.out.print(list);
    }
}