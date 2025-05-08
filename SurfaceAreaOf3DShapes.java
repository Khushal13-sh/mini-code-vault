/**
 * Problem Title: Surface Area of 3D Shapes
 * Difficulty: Easy
 * 
 * ✅ Problem Description:
 * You are given an n x n grid where:
 * - grid[i][j] represents a tower of 'v' cubes placed on cell (i, j).
 * - The value 'v' indicates the height of the cube tower.
 * 
 * After placing the cubes:
 * - Any directly adjacent cubes are glued together, forming irregular 3D shapes.
 * - The bottom face of each shape counts toward the surface area.
 * 
 * 🧠 Goal:
 * Return the total surface area of the resulting 3D shapes.
 * 
 * 📥 Example 1:
 * Input:  grid = [[1,2],[3,4]]
 * Output: 34
 * 
 * 📥 Example 2:
 * Input:  grid = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 32
 * 
 * 📥 Example 3:
 * Input:  grid = [[2,2,2],[2,1,2],[2,2,2]]
 * Output: 46
 * 
 * 📌 Constraints:
 * - n == grid.length == grid[i].length
 * - 1 <= n <= 50
 * - 0 <= grid[i][j] <= 50
 */

public class SurfaceAreaOf3DShapes {

    /**
     * 🧠 Logic:
     * - The surface area of a single cube is 6.
     * - When cubes are adjacent, the shared face is counted only once.
     * - Calculate the exposed faces after gluing:
     *   - Add top and bottom faces (2 units)
     *   - Subtract the covered faces between adjacent cubes.
     */
    public static int surfaceArea(int[][] grid) {
        int n = grid.length;
        int area = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int height = grid[i][j];
                
                // Skip if no cubes are present
                if (height > 0) {
                    // Top and bottom faces (always 2 units if height > 0)
                    area += 2;

                    // Calculate exposed sides by comparing with adjacent cells
                    int front = height;
                    int back = height;

                    if (i > 0) front -= Math.min(height, grid[i - 1][j]);  // Front face exposure
                    if (i < n - 1) back -= Math.min(height, grid[i + 1][j]); // Back face exposure
                    area += front + back;

                    int left = height;
                    int right = height;

                    if (j > 0) left -= Math.min(height, grid[i][j - 1]);    // Left face exposure
                    if (j < n - 1) right -= Math.min(height, grid[i][j + 1]); // Right face exposure
                    area += left + right;
                }
            }
        }

        return area;
    }

    // 🧪 Main method to test the logic
    public static void main(String[] args) {
        int[][] grid1 = {{1, 2}, {3, 4}};
        System.out.println("Surface Area: " + surfaceArea(grid1));  // Expected: 34

        int[][] grid2 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println("Surface Area: " + surfaceArea(grid2));  // Expected: 32

        int[][] grid3 = {{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};
        System.out.println("Surface Area: " + surfaceArea(grid3));  // Expected: 46
    }
}
