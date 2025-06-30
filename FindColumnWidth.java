/**
 * Problem: Find the Width of Columns of a Grid
 * Difficulty: Easy
 *
 * For each column in the grid, find the maximum number of characters (including minus sign)
 * needed to represent an integer in that column.
 */

public class FindColumnWidth {
    public int[] findColumnWidth(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] widths = new int[cols];

        for (int col = 0; col < cols; col++) {
            int maxWidth = 0;
            for (int row = 0; row < rows; row++) {
                int length = String.valueOf(grid[row][col]).length();
                maxWidth = Math.max(maxWidth, length);
            }
            widths[col] = maxWidth;
        }

        return widths;
    }

    public static void main(String[] args) {
        FindColumnWidth solution = new FindColumnWidth();

        int[][] grid1 = {{1}, {22}, {333}};
        int[][] grid2 = {{-15, 1, 3}, {15, 7, 12}, {5, 6, -2}};

        System.out.println(Arrays.toString(solution.findColumnWidth(grid1))); // Output: [3]
        System.out.println(Arrays.toString(solution.findColumnWidth(grid2))); // Output: [3, 1, 2]
    }
}
