package by.pvt.data;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class InputDataGeneratorTest {

    @Test
    public void generate() {

        assertNull(InputDataGenerator.generate(Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE));

        assertNull(InputDataGenerator.generate(-1, 0, 100));

        assertNotNull(InputDataGenerator.generate(0, 0, 100));

        Arrays.stream(InputDataGenerator.generate(100, 0, 100))
                .forEach(x -> {
                    assertTrue(0 <= x && x < 100);
                    System.out.println(x);
                });

        //        assertEquals(true,false);
    }
}