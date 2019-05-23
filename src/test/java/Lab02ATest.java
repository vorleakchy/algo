import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Lab02ATest {

    @Test
    void merge() {
        int[] arr1 = new int[]{1, 4, 5, 8, 17};
        int[] arr2 = new int[]{2, 4, 8, 11, 13, 21, 23, 25};
        int[] expected = new int[]{1, 2,4,4,5,8,8,  11, 13, 17, 21, 23, 25};

        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(Lab02A.merge(arr1, arr2)));
    }
}