import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lab01BTest {

    @Test
    void generate() {
        for(int i = 0; i < 20; ++i) {
            System.out.println(Lab01B.generate(i));
        }
    }

    @Test
    void log2() {
        System.out.println(Lab01B.log2(8));
        System.out.println(Lab01B.log2(32));
    }
}