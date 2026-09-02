/*
 add solution for container with most water
*/

/**
 * Problem: Container With Most Water
 * Difficulty: Medium
 *
 * Description:
 * Given an integer array height, where each element
 * represents the height of a vertical line, find two
 * lines that can form a container containing the
 * maximum amount of water.
 *
 * Key Insight:
 * The amount of water is determined by:
 *
 *     width * minimum height
 *
 * We use two pointers starting from both ends.
 *
 * Since the shorter line limits the amount of water,
 * we move the pointer pointing to the shorter line.
 *
 * Approach:
 * - Start left pointer at index 0.
 * - Start right pointer at the last index.
 * - Calculate the current area.
 * - Update the maximum area.
 * - Move the pointer with the smaller height.
 * - Continue until the pointers meet.
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(1)
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxWater = 0;

        while (left < right) {

            // Calculate the width between the two lines.
            int width = right - left;

            // The shorter line determines the water height.
            int h = Math.min(height[left], height[right]);

            // Calculate the current container area.
            int area = width * h;

            // Update the maximum water found.
            maxWater = Math.max(maxWater, area);

            // Move the pointer with the smaller height.
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {

        ContainerWithMostWater obj =
                new ContainerWithMostWater();

        // Example 1
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int result1 = obj.maxArea(height1);

        System.out.println("Input 1: [1,8,6,2,5,4,8,3,7]");
        System.out.println("Output 1: " + result1);

        // Example 2
        int[] height2 = {1, 1};

        int result2 = obj.maxArea(height2);

        System.out.println("Input 2: [1,1]");
        System.out.println("Output 2: " + result2);
    }
}