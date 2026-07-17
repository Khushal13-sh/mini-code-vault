/*
 add solution for checking unique middle element in array
*/

/**
 * Problem: Unique Middle Element
 * Difficulty: Easy
 *
 * Description:
 * Given an integer array of odd length,
 * return true if the middle element appears
 * exactly once in the array.
 * Otherwise, return false.
 *
 * Key Insight:
 * - Find the middle element.
 * - Count its occurrences in the array.
 * - It is unique only if its count is one.
 *
 * Approach:
 * - Get the middle element using nums.length / 2.
 * - Traverse the array and count its occurrences.
 * - Return true if the count is exactly one.
 *
 * Why this works:
 * The problem only requires checking the
 * frequency of the middle element, so a
 * single traversal is sufficient.
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(1)
 * Only a few extra variables are used.
 */
public class UniqueMiddleElement {

    public boolean isMiddleElementUnique(int[] nums) {

        int middle = nums[nums.length / 2];
        int count = 0;

        for (int num : nums) {
            if (num == middle) {
                count++;
            }
        }

        return count == 1;
    }

    public static void main(String[] args) {

        UniqueMiddleElement obj =
                new UniqueMiddleElement();

        // Example 1
        int[] nums1 = {1, 2, 3};
        System.out.println("Output 1: " +
                obj.isMiddleElementUnique(nums1));

        // Example 2
        int[] nums2 = {1, 2, 2};
        System.out.println("Output 2: " +
                obj.isMiddleElementUnique(nums2));
    }
}