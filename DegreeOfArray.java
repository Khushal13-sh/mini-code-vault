/**
 * Problem: Degree of an Array
 * Difficulty: Easy
 *
 * 🔍 Description:
 * Find the smallest length of a contiguous subarray that has the same degree
 * (max frequency of any number) as the original array.
 *
 * 🧪 Example:
 * Input: [1,2,2,3,1]
 * Output: 2
 */

import java.util.*;

public class DegreeOfArray {

    public static int findShortestSubArray(int[] nums) {
        // Store frequency of elements
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        // Store first occurrence of each element
        HashMap<Integer, Integer> firstIndexMap = new HashMap<>();
        // Store last occurrence of each element
        HashMap<Integer, Integer> lastIndexMap = new HashMap<>();

        // Traverse the array to populate maps
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

            if (!firstIndexMap.containsKey(num)) {
                firstIndexMap.put(num, i);
            }

            lastIndexMap.put(num, i);
        }

        // Find the max frequency (degree)
        int maxFreq = Collections.max(freqMap.values());
        int minLength = nums.length;

        // Find the shortest subarray among elements with max frequency
        for (int num : freqMap.keySet()) {
            if (freqMap.get(num) == maxFreq) {
                int length = lastIndexMap.get(num) - firstIndexMap.get(num) + 1;
                minLength = Math.min(minLength, length);
            }
        }

        return minLength;
    }

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 1}));      // Output: 2
        System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2})); // Output: 6
        System.out.println(findShortestSubArray(new int[]{1, 1, 1, 1}));          // Output: 4
        System.out.println(findShortestSubArray(new int[]{1, 2, 3}));             // Output: 1
    }
}
