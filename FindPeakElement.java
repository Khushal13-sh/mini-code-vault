
/*
 * Problem: Find Peak Element
 * LeetCode: 162
 * Difficulty: Medium
 *
 * Approach: Binary Search
 *
 * A peak element is greater than its immediate neighbours.
 *
 * Instead of checking every element, we compare the middle
 * element with the element immediately to its right.
 *
 * If nums[mid] > nums[mid + 1]:
 *     A peak exists at mid or somewhere on the left.
 *     So, move high to mid.
 *
 * Otherwise:
 *     A peak exists somewhere on the right.
 *     So, move low to mid + 1.
 *
 * Continue until low and high point to the same index.
 * That index is the peak element.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

public class FindPeakElement {

    public int findPeakElement(int[] nums) {

        // Initialize the search range.
        int low = 0;
        int high = nums.length - 1;

        // Continue until only one candidate index remains.
        while (low < high) {

            // Calculate the middle index.
            int mid = low + (high - low) / 2;

            // Check whether the middle element is greater
            // than its right neighbour.
            if (nums[mid] > nums[mid + 1]) {

                // We are on a descending slope.
                // A peak exists at mid or somewhere on the left.
                high = mid;

            } else {

                // We are on an ascending slope.
                // A peak exists somewhere on the right.
                low = mid + 1;
            }
        }

        // low and high point to the same peak index.
        return low;
    }

    public static void main(String[] args) {

        FindPeakElement solution = new FindPeakElement();

        // Test Case 1
        int[] nums1 = {1, 2, 3, 1};

        System.out.println(
            solution.findPeakElement(nums1)
        ); // 2

        // Test Case 2
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};

        System.out.println(
            solution.findPeakElement(nums2)
        ); // 5 or 1

        // Test Case 3: Peak at the first index
        int[] nums3 = {5, 4, 3, 2, 1};

        System.out.println(
            solution.findPeakElement(nums3)
        ); // 0

        // Test Case 4: Peak at the last index
        int[] nums4 = {1, 2, 3, 4, 5};

        System.out.println(
            solution.findPeakElement(nums4)
        ); // 4

        // Test Case 5: Only one element
        int[] nums5 = {10};

        System.out.println(
            solution.findPeakElement(nums5)
        ); // 0
    }
}
