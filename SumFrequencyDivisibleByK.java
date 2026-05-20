/*
 add solution for sum of elements with frequency divisible by k using hashmap
*/

/**
 * Problem: Sum of Elements With Frequency Divisible by K
 * Difficulty: Easy
 *
 * Description:
 * Return the sum of all elements whose total frequency
 * in the array is divisible by k.
 *
 * If an element qualifies, include it in the sum
 * as many times as it appears.
 *
 * Approach:
 * - Use HashMap to count frequency of each number
 * - Traverse array again
 * - If frequency of current number is divisible by k,
 *   add it to the sum
 *
 * Why this works:
 * Frequency map gives occurrence count in O(1) lookup.
 * We can easily check divisibility condition for every element.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

public class SumFrequencyDivisibleByK {

    public int sumDivisibleByK(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();

        // Count frequencies
        for (int num : nums) {

            freq.put(num,
                    freq.getOrDefault(num, 0) + 1);
        }

        int sum = 0;

        // Add qualifying elements
        for (int num : nums) {

            if (freq.get(num) % k == 0) {
                sum += num;
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        SumFrequencyDivisibleByK obj =
                new SumFrequencyDivisibleByK();

        // Example 1
        int[] nums1 = {1,2,2,3,3,3,3,4};

        System.out.println(
            "Output 1: " +
            obj.sumDivisibleByK(nums1, 2)
        ); // 16

        // Example 2
        int[] nums2 = {1,2,3,4,5};

        System.out.println(
            "Output 2: " +
            obj.sumDivisibleByK(nums2, 2)
        ); // 0

        // Example 3
        int[] nums3 = {4,4,4,1,2,3};

        System.out.println(
            "Output 3: " +
            obj.sumDivisibleByK(nums3, 3)
        ); // 12
    }
}