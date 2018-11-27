package by.pvt.math;

import by.pvt.data.InputDataGenerator;
import by.pvt.service.AverageService;
import by.pvt.service.AverageServiceImpl;

import java.util.Arrays;
import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {

        AverageService averageService = new AverageServiceImpl();

        int[] inputData = InputDataGenerator.generate(11, 1, 10);

        System.out.println("Array: " + Arrays.toString(inputData));

        System.out.println("Average: " + averageService.getMean(inputData));

        System.out.println("Mode: " + averageService.getMode(inputData));

        System.out.println("Median: " + averageService.getMedian(inputData));

    }
}
