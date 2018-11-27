package by.pvt.service;

import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;

public class AverageServiceImplTest {

    @Test
    public void getMean() {

        AverageService averageService = new AverageServiceImpl();

        try {
            averageService.getMean(null);
        } catch (Exception e) {
            assertEquals(e.getClass(), InvalidParameterException.class);
        }

        assertEquals(0.0, averageService.getMean(new int[]{0, 0, 0, 0}), 0.0);

        assertEquals(1.5, averageService.getMean(new int[]{1, 2}), 0.0);
    }

    @Test
    public void getMode() {

        AverageService averageService = new AverageServiceImpl();

        try {
            averageService.getMode(null);
        } catch (Exception e) {
            assertEquals(e.getClass(), InvalidParameterException.class);
        }

        assertEquals("[5, 30]", averageService.getMode(new int[]{30, 5, 23, 5, 28, 30}));

        assertEquals("[35, 30]", averageService.getMode(new int[]{40, 35, 30, 25, 30, 35}));

        assertEquals("The row has not mode", averageService.getMode(new int[]{-21, -33, -35, -19, -20, -22}));

        assertEquals("[26]", averageService.getMode(new int[]{32, 26, 18, 26, 15, 21, 26}));
    }

    @Test
    public void getMedian() {

        AverageService averageService = new AverageServiceImpl();

        try {
            averageService.getMedian(null);
        } catch (Exception e) {
            assertEquals(e.getClass(), InvalidParameterException.class);
        }

        assertEquals(25.5, averageService.getMedian(new int[]{30, 5, 23, 5, 28, 30}), 0.0);

        assertEquals(26, averageService.getMedian(new int[]{32, 26, 18, 26, 15, 21, 26}), 0.0);

        assertEquals(42, averageService.getMedian(new int[]{38, 42, 36, 45, 48, 45, 45, 42, 40, 47, 39}), 0.0);

        assertEquals(32.5, averageService.getMedian(new int[]{40, 35, 30, 25, 30, 35}), 0.0);
    }
}