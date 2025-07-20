/**
 * Problem: Maximum Number of Pairs in Array
 * Difficulty: Easy
 *
 * Given an integer array, count how many pairs can be formed by removing equal elements
 * and how many elements are left unpaired.
 */

import java.util.*;

public class MaximumNumberOfPairs {

    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int pairs = 0;
        int leftovers = 0;

        for (int count : freqMap.values()) {
            pairs += count / 2;
            leftovers += count % 2;
        }

        return new int[]{pairs, leftovers};
    }

    public static void main(String[] args) {
        MaximumNumberOfPairs solution = new MaximumNumberOfPairs();

        System.out.println(Arrays.toString(solution.numberOfPairs(new int[]{1, 3, 2, 1, 3, 2, 2}))); // [3, 1]
        System.out.println(Arrays.toString(solution.numberOfPairs(new int[]{1, 1})));               // [1, 0]
        System.out.println(Arrays.toString(solution.numberOfPairs(new int[]{0})));                  // [0, 1]
    }
}
