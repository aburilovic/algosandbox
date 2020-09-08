// Given an array of integers, find and print the maximum number of integers you can select from the array such that the absolute
// difference between any two of the chosen integers is less than or equal to 1.

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PickingNumbers {

    public static void main(String[] args) {
        int[] array = {9,9,9,9,9,9,9, 1, 1, 2, 2, 3, 1, 2, 4,4,4,4,5,5,5,5,5,5,5,8,8,8,8,8};

        int[] result = numberPicker(array);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int[] numberPicker(int[] input) {
        final HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            int count = hashMap.getOrDefault(input[i], 0);
            hashMap.put(input[i], ++count);
        }
        int maxValue = -1;
        int maxKey = -1;

        Iterator<Map.Entry<Integer, Integer>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (maxValue == -1) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            } else {
                int sum = entry.getValue() + hashMap.getOrDefault(entry.getKey() - 1, 0);
                if (sum > maxValue) {
                    maxValue = sum;
                    maxKey = entry.getKey();
                }
            }
        }

        int firstValue = maxKey;
        int firstCounter = hashMap.getOrDefault(firstValue, 0);
        int secondValue = maxKey - 1;
        int secondCounter = hashMap.getOrDefault(secondValue, 0);

        int totalSize = firstCounter + secondCounter;
        int[] result = new int[totalSize];

        for (int i = 0; i < firstCounter; i++) {
            result[i] = firstValue;
        }

        for (int i = firstCounter; i < totalSize; i++) {
            result[i] = secondValue;
        }

        return result;
    }
}
