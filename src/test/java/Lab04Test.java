import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Lab04Test {

    @Test
    void sidewaySort() {
        int[] arr = new int[]{9, 5, 2, 4, 1, 6};
        int[] expected = new int[]{1, 9, 2, 6, 4, 5};

        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(Lab04.sidewaySort(arr)));
    }

    @Test
    void sidewayQuickSort() {
        int[] arr = new int[]{9, 5, 2, 4, 1, 6};
        int[] expected = new int[]{1, 9, 2, 6, 4, 5};

        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(Lab04.sidewayQuickSort(arr)));
    }
}