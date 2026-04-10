/*
 add solution for maximum area of rectangle with longest diagonal using math comparison
*/

/**
 * Problem: Maximum Area of Longest Diagonal Rectangle
 * Difficulty: Easy
 *
 * Description:
 * Given multiple rectangles, find the one with the longest diagonal.
 * If multiple rectangles have the same diagonal length, return the one with the maximum area.
 *
 * Approach:
 * - For each rectangle:
 *      → Compute diagonal² = l*l + w*w (avoid sqrt for efficiency)
 *      → Compute area = l * w
 * - Track:
 *      → Maximum diagonal value
 *      → Corresponding maximum area
 * - If diagonal is same → compare area
 *
 * Why this works:
 * Comparing squared diagonals avoids floating-point operations and is sufficient
 * for comparison.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MaxAreaLongestDiagonal {

    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagSq = 0;
        int maxArea = 0;

        for (int[] rect : dimensions) {
            int l = rect[0];
            int w = rect[1];

            int diagSq = l * l + w * w;
            int area = l * w;

            if (diagSq > maxDiagSq) {
                maxDiagSq = diagSq;
                maxArea = area;
            } else if (diagSq == maxDiagSq) {
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        MaxAreaLongestDiagonal obj = new MaxAreaLongestDiagonal();

        // Example 1
        int[][] dims1 = {{9, 3}, {8, 6}};
        System.out.println("Output 1: " + obj.areaOfMaxDiagonal(dims1)); // 48

        // Example 2
        int[][] dims2 = {{3, 4}, {4, 3}};
        System.out.println("Output 2: " + obj.areaOfMaxDiagonal(dims2)); // 12
    }
}