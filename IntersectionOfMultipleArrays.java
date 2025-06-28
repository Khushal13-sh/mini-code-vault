/**
 * Problem: Intersection of Multiple Arrays
 * Difficulty: Easy
 *
 * For each sub-array in nums, find the common elements that appear in all arrays.
 * The result should be sorted in ascending order.
 */

import java.util.*;

public class IntersectionOfMultipleArrays {
    public List<Integer> intersection(int[][] nums) {
        // Frequency map for counting element appearances across all arrays
        int[] freq = new int[1001]; 

        for (int[] arr : nums) {
            Set<Integer> seen = new HashSet<>();
            for (int num : arr) {
                // Avoid counting duplicates in the same array
                if (seen.add(num)) {
                    freq[num]++;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            if (freq[i] == nums.length) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        IntersectionOfMultipleArrays solution = new IntersectionOfMultipleArrays();

        int[][] nums1 = {{3, 1, 2, 4, 5}, {1, 2, 3, 4}, {3, 4, 5, 6}};
        int[][] nums2 = {{1, 2, 3}, {4, 5, 6}};

        System.out.println(solution.intersection(nums1)); // [3, 4]
        System.out.println(solution.intersection(nums2)); // []
    }
}
