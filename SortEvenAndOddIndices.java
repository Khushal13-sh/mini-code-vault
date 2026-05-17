/*
 add solution for sorting even and odd indices independently using lists and sorting
*/

/**
 * Problem: Sort Even and Odd Indices Independently
 * Difficulty: Easy
 *
 * Description:
 * Rearrange the array such that:
 * - Values at even indices are sorted in non-decreasing order
 * - Values at odd indices are sorted in non-increasing order
 *
 * Return the modified array.
 *
 * Approach:
 * - Store even index values in one list
 * - Store odd index values in another list
 * - Sort even list in ascending order
 * - Sort odd list in descending order
 * - Place values back into original array
 *
 * Why this works:
 * Separating even and odd indexed values allows independent sorting
 * according to the required order.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.*;

public class SortEvenAndOddIndices {

    public int[] sortEvenOdd(int[] nums) {

        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        // Separate even and odd index values
        for (int i = 0; i < nums.length; i++) {

            if (i % 2 == 0) {
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
        }

        // Sort even indices in ascending order
        Collections.sort(even);

        // Sort odd indices in descending order
        odd.sort(Collections.reverseOrder());

        int e = 0;
        int o = 0;

        // Rebuild array
        for (int i = 0; i < nums.length; i++) {

            if (i % 2 == 0) {
                nums[i] = even.get(e++);
            } else {
                nums[i] = odd.get(o++);
            }
        }

        return nums;
    }

    public static void main(String[] args) {

        SortEvenAndOddIndices obj = new SortEvenAndOddIndices();

        // Example 1
        int[] nums1 = {4, 1, 2, 3};

        System.out.println(
            "Output 1: " +
            Arrays.toString(obj.sortEvenOdd(nums1))
        );
        // [2, 3, 4, 1]

        // Example 2
        int[] nums2 = {2, 1};

        System.out.println(
            "Output 2: " +
            Arrays.toString(obj.sortEvenOdd(nums2))
        );
        // [2, 1]
    }
}