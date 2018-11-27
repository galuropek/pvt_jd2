package by.pvt.service;

import java.security.InvalidParameterException;
import java.util.*;

public class AverageServiceImpl implements AverageService {

    @Override
    public double getMean(int[] inputData) {

        if (inputData == null)
            throw new InvalidParameterException("Input data cannot be null");

        return Arrays.stream(inputData)
                .average()
                .orElse(Double.NaN);
    }

    @Override
    public String getMode(int[] inputData) {

        if (inputData == null)
            throw new InvalidParameterException("Input data cannot be null");

        ArrayList list = new ArrayList();
        int maxValue = 0;
        HashMap<Integer, Integer> repeatMode = getRepeatMode(inputData);
        for (Map.Entry<Integer, Integer> entry : repeatMode.entrySet()) {
            Integer value = entry.getValue();
            if (value > maxValue)
                maxValue = value;
        }
        for (Map.Entry<Integer, Integer> entry : repeatMode.entrySet()) {
            Integer value = entry.getValue();
            if (value == maxValue)
                list.add(entry.getKey());
        }
        if (!list.isEmpty())
            return list.toString();
        else
            return "The row has not mode";
    }

    @Override
    public double getMedian(int[] inputData) {

        if (inputData == null)
            throw new InvalidParameterException("Input data cannot be null");

        double median;
        int[] sortArray = Arrays.copyOf(inputData, inputData.length);
        Arrays.sort(sortArray);
        int lengthArray = inputData.length;
        int avg = Math.round((lengthArray - 1) / 2);
        if (lengthArray % 2 == 0) {
            median = sortArray[avg] + sortArray[avg + 1];
            return (double) median / 2;
        } else {
            return median = sortArray[avg];
        }
    }

    private HashMap<Integer, Integer> getRepeatMode(int[] inputData) {
        int[] sortArray = Arrays.copyOf(inputData, inputData.length);
        Arrays.sort(sortArray);
        int counter = 0;
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < sortArray.length - 1; i++) {
            if (sortArray[i] == sortArray[i + 1]) {
                int index = i + 1;
                int count = 1;
                while (sortArray[i] == sortArray[index]) {
                    count++;
                    if (index < sortArray.length - 1)
                        index++;
                    else
                        break;
                }
                if (count > counter || count == counter) {
                    counter = count;
                    result.put(sortArray[i], counter);
                    i = index - 1;
                }
            }
        }
        return result;
    }
}
