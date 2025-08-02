import java.util.*;

/**
 * Problem: Sort Array by Increasing Frequency
 * Difficulty: Easy
 *
 * Given an array of integers nums, sort the array based on:
 * 1. Frequency in ascending order.
 * 2. If frequencies are the same, sort values in descending order.
 *
 * Approach:
 * - Count frequencies using a HashMap.
 * - Use a simple Bubble Sort to sort according to the problem's rules:
 *      - freq(a) < freq(b) → a before b
 *      - freq(a) == freq(b) → larger value first
 */
public class SortArrayByFrequency {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        // Bubble sort based on frequency and value
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                int freq1 = freqMap.get(arr[j]);
                int freq2 = freqMap.get(arr[j + 1]);

                if (freq1 > freq2 || (freq1 == freq2 && arr[j] < arr[j + 1])) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // Convert back to primitive int array
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = arr[i];
        }
        return result;   
    }

    public static void main(String[] args) {
        SortArrayByFrequency solution = new SortArrayByFrequency();

        int[] nums1 = {1, 1, 2, 2, 2, 3};
        System.out.println(Arrays.toString(solution.frequencySort(nums1))); 
        // Expected: [3, 1, 1, 2, 2, 2]

        int[] nums2 = {2, 3, 1, 3, 2};
        System.out.println(Arrays.toString(solution.frequencySort(nums2))); 
        // Expected: [1, 3, 3, 2, 2]

        int[] nums3 = {-1, 1, -6, 4, 5, -6, 1, 4, 1};
        System.out.println(Arrays.toString(solution.frequencySort(nums3))); 
        // Expected: [5, -1, 4, 4, -6, -6, 1, 1, 1]
    }
}
