import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Lab03A_Rec_SortArrayTest {

    @Test
    void merge() {
        int[] arr1 = new int[]{1, 3};
        int[] arr2 = new int[]{2, 4, 5};
        int[] expected = new int[]{1, 2, 3, 4, 5};

        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(Lab03A_RecSort_Array.merge(arr1, arr2)));
    }
}