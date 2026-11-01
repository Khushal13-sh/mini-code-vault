
/**
 * Problem: Find Minimum in Rotated Sorted Array
 * LeetCode: 153
 * Difficulty: Medium
 *
 * Description:
 * Given an ascending sorted array that has been rotated,
 * find and return its minimum element.
 *
 * Approach:
 * Binary Search.
 *
 * We compare the middle element with the last element
 * to determine which half contains the minimum.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {

        // Starting index of the search range.
        int low = 0;

        // Ending index of the search range.
        int high = nums.length - 1;

        // Continue until only one possible minimum index remains.
        while (low < high) {

            // Calculate the middle index.
            // This formula avoids integer overflow.
            int mid = low + (high - low) / 2;

            /*
             * Case 1:
             * If nums[mid] is greater than nums[high],
             * the minimum must be on the right side of mid.
             *
             * Example:
             * [4, 5, 6, 7, 1, 2, 3]
             *          mid       high
             *
             * Since nums[mid] > nums[high],
             * move low to mid + 1.
             */
            if (nums[mid] > nums[high]) {

                low = mid + 1;
            }

            /*
             * Case 2:
             * If nums[mid] is smaller than or equal to nums[high],
             * the minimum is either at mid or on its left side.
             *
             * We use mid itself because it might be
             * the minimum element.
             */
            else {

                high = mid;
            }
        }

        // When low == high, both pointers point to the minimum.
        return nums[low];
    }

    /**
     * Main method to test the solution.
     */
    public static void main(String[] args) {

        FindMinimumInRotatedSortedArray solution =
                new FindMinimumInRotatedSortedArray();

        // Test Case 1
        int[] nums1 = {3, 4, 5, 1, 2};

        System.out.println("Input: [3, 4, 5, 1, 2]");
        System.out.println("Minimum: " + solution.findMin(nums1));

        // Test Case 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};

        System.out.println("\nInput: [4, 5, 6, 7, 0, 1, 2]");
        System.out.println("Minimum: " + solution.findMin(nums2));

        // Test Case 3
        int[] nums3 = {11, 13, 15, 17};

        System.out.println("\nInput: [11, 13, 15, 17]");
        System.out.println("Minimum: " + solution.findMin(nums3));

        // Test Case 4: Single element
        int[] nums4 = {5};

        System.out.println("\nInput: [5]");
        System.out.println("Minimum: " + solution.findMin(nums4));

        // Test Case 5: Minimum at the beginning
        int[] nums5 = {2, 3, 4, 5, 1};

        System.out.println("\nInput: [2, 3, 4, 5, 1]");
        System.out.println("Minimum: " + solution.findMin(nums5));
    }
}
