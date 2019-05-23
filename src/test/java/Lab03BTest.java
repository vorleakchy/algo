import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lab03BTest {

    @Test
    void isPrime() {
        Assert.assertEquals(false, Lab03B.isPrime(1));

        Assert.assertEquals(true, Lab03B.isPrime(2));
        Assert.assertEquals(true, Lab03B.isPrime(3));
        Assert.assertEquals(true, Lab03B.isPrime(5));
        Assert.assertEquals(true, Lab03B.isPrime(7));
        Assert.assertEquals(true, Lab03B.isPrime(11));

        Assert.assertEquals(false, Lab03B.isPrime(4));
        Assert.assertEquals(false, Lab03B.isPrime(8));

        Assert.assertEquals(false, Lab03B.isPrime(15));
    }

    @Test
    void fibIterative() {
        Assert.assertEquals(0, Lab03B.fibIterative(0));
        Assert.assertEquals(1, Lab03B.fibIterative(1));
        Assert.assertEquals(1, Lab03B.fibIterative(2));
        Assert.assertEquals(2, Lab03B.fibIterative(3));
        Assert.assertEquals(3, Lab03B.fibIterative(4));
        Assert.assertEquals(5, Lab03B.fibIterative(5));
        Assert.assertEquals(8, Lab03B.fibIterative(6));
    }

    @Test
    void fibRecursive() {
        Assert.assertEquals(0, Lab03B.fibRecursive(0));
        Assert.assertEquals(1, Lab03B.fibRecursive(1));
        Assert.assertEquals(1, Lab03B.fibRecursive(2));
        Assert.assertEquals(2, Lab03B.fibRecursive(3));
        Assert.assertEquals(3, Lab03B.fibRecursive(4));
        Assert.assertEquals(5, Lab03B.fibRecursive(5));
        Assert.assertEquals(8, Lab03B.fibRecursive(6));
    }

    @Test
    void kSmallest() {
        Assert.assertEquals(3, Lab03B.kSmallest(new int[]{8, 4, 1, 9, 3, 6}, 2));
        Assert.assertEquals(4, Lab03B.kSmallest(new int[]{8, 4, 1, 9, 3, 6}, 3));
    }

    @Test
    void gcd() {
        Assert.assertEquals(4, Lab03B.gcd(12, 8));
        Assert.assertEquals(6, Lab03B.gcd(54, 24));
    }

    @Test
    void isGCDFormWithGiven() {
        Assert.assertEquals(false, Lab03B.isGCDFormWithGiven(12, 8));
        Assert.assertEquals(true, Lab03B.isGCDFormWithGiven(54, 24));
    }
}