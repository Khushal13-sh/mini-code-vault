/**
 * Problem Title: Projection Area of 3D Shapes
 * Difficulty: Easy
 * 
 * ✅ Problem Description:
 * Given an n x n grid where each value grid[i][j] represents the height of towers at (i, j):
 * - A projection is the "shadow" or area visible when looking at the 3D structure from the top, front, and side.
 * 
 * 💡 Task:
 * Calculate the total area of the three projections:
 * 1. Top (XY) - Number of non-zero values in the grid.
 * 2. Front (YZ) - Maximum height in each column.
 * 3. Side (ZX) - Maximum height in each row.
 * 
 * 📥 Example 1:
 * Input: grid = [[1,2],[3,4]]
 * Output: 17
 * 
 * 📥 Example 2:
 * Input: grid = [[2]]
 * Output: 5
 * 
 * 📥 Example 3:
 * Input: grid = [[1,0],[0,2]]
 * Output: 8
 * 
 * 📌 Constraints:
 * - 1 <= n <= 50
 * - 0 <= grid[i][j] <= 50
 */

public class ProjectionArea3DShapes {

    /**
     * 🧠 Logic:
     * 1. Top projection (XY plane) - Count of all non-zero values in the grid.
     * 2. Front projection (YZ plane) - Sum of the maximum values in each column.
     * 3. Side projection (ZX plane) - Sum of the maximum values in each row.
     * 
     * Total projection area = XY + YZ + ZX
     */
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int xyProjection = 0;
        int yzProjection = 0;
        int zxProjection = 0;

        for (int i = 0; i < n; i++) {
            int maxRow = 0;  // Maximum value in the current row
            int maxCol = 0;  // Maximum value in the current column
            for (int j = 0; j < n; j++) {
                // Top (XY) projection - count non-zero values
                if (grid[i][j] > 0) {
                    xyProjection++;
                }

                // Side (ZX) projection - max in the current row
                maxRow = Math.max(maxRow, grid[i][j]);

                // Front (YZ) projection - max in the current column
                maxCol = Math.max(maxCol, grid[j][i]);
            }
            zxProjection += maxRow;
            yzProjection += maxCol;
        }

        return xyProjection + yzProjection + zxProjection;
    }

    // 🧪 Main method to test the logic
    public static void main(String[] args) {
        ProjectionArea3DShapes solution = new ProjectionArea3DShapes();

        // Test cases
        int[][] grid1 = {{1, 2}, {3, 4}};
        int[][] grid2 = {{2}};
        int[][] grid3 = {{1, 0}, {0, 2}};

        System.out.println("Projection Area (grid1): " + solution.projectionArea(grid1));  // Output: 17
        System.out.println("Projection Area (grid2): " + solution.projectionArea(grid2));  // Output: 5
        System.out.println("Projection Area (grid3): " + solution.projectionArea(grid3));  // Output: 8
    }
}
