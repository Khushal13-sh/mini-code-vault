/*
 add solution for maximizing expression of three elements using two maximums and one minimum
*/

/**
 * Problem: Maximize Expression of Three Elements
 * Difficulty: Easy
 *
 * Description:
 * Choose three distinct elements a, b, c such that:
 * a + b - c is maximized.
 *
 * Key Insight:
 * - To maximize (a + b - c):
 *      → pick two largest elements (a, b)
 *      → pick smallest element (c)
 *
 * Approach:
 * - Traverse array once
 * - Track:
 *      → max1 (largest)
 *      → max2 (second largest)
 *      → min (smallest)
 *
 * Why this works:
 * Maximizing sum → take biggest values
 * Minimizing subtraction → subtract smallest value
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MaximizeExpressionThreeElements {

    public int maximizeExpressionOfThree(int[] nums) {

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : nums) {

            if (num < min) {
                min = num;
            }

            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        return max1 + max2 - min;
    }

    public static void main(String[] args) {
        MaximizeExpressionThreeElements obj = new MaximizeExpressionThreeElements();

        // Example 1
        int[] nums1 = {1, 4, 2, 5};
        System.out.println("Output 1: " + obj.maximizeExpressionOfThree(nums1)); // 8

        // Example 2
        int[] nums2 = {-2, 0, 5, -2, 4};
        System.out.println("Output 2: " + obj.maximizeExpressionOfThree(nums2)); // 11
    }
}