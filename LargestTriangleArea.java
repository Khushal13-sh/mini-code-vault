/**
 * Problem Title: Largest Triangle Area
 * Difficulty: Easy
 * 
 * ✅ Problem Description:
 * Given an array of points on the X-Y plane (points[i] = [xi, yi]), find the 
 * area of the **largest triangle** that can be formed by any three different points.
 * 
 * 🔹 Important:
 * - The answer must be accurate within 10^-5 of the actual value.
 * 
 * 📥 Example 1:
 * Input:  points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * Output: 2.00000
 * Explanation: The largest triangle has vertices (0,0), (0,2), (2,0).
 * 
 * 📥 Example 2:
 * Input:  points = [[1,0],[0,0],[0,1]]
 * Output: 0.50000
 * 
 * 📌 Constraints:
 * - 3 <= points.length <= 50
 * - -50 <= xi, yi <= 50
 * - All points are unique
 */

public class LargestTriangleArea {

    /**
     * 🧠 Logic:
     * - Calculate the area of a triangle formed by three points using the 
     *   determinant formula:
     *   
     *   Area = 0.5 * | x1(y2 - y3) + x2(y3 - y1) + x3(y1 - y2) |
     *   
     * - Iterate over all combinations of three points and find the maximum area.
     */
    public static double largestTriangleArea(int[][] points) {
        double maxArea = 0;
        int n = points.length;

        // Iterate over all combinations of three points
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Calculate area using the determinant formula
                    double area = Math.abs(
                        points[i][0] * (points[j][1] - points[k][1]) +
                        points[j][0] * (points[k][1] - points[i][1]) +
                        points[k][0] * (points[i][1] - points[j][1])
                    ) / 2.0;

                    // Update the maximum area
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    // 🧪 Main method to test the logic
    public static void main(String[] args) {
        int[][] points1 = {{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}};
        System.out.printf("Largest Triangle Area: %.5f%n", largestTriangleArea(points1));  // Expected: 2.00000

        int[][] points2 = {{1, 0}, {0, 0}, {0, 1}};
        System.out.printf("Largest Triangle Area: %.5f%n", largestTriangleArea(points2));  // Expected: 0.50000
    }
}
