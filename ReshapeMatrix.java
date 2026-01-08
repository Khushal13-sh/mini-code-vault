/**
 * Problem: Reshape the Matrix
 * Difficulty: Easy
 *
 * Reshape an m x n matrix into r x c while
 * preserving row-wise traversal order.
 */

public class ReshapeMatrix {

    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int m = mat.length;
        int n = mat[0].length;

        // Check if reshape is possible
        if (m * n != r * c) {
            return mat;
        }

        int[][] result = new int[r][c];
        int row = 0, col = 0;

        // Traverse original matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                result[row][col] = mat[i][j];
                col++;

                // Move to next row when column ends
                if (col == c) {
                    col = 0;
                    row++;
                }
            }
        }

        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        ReshapeMatrix obj = new ReshapeMatrix();

        int[][] mat = {{1,2},{3,4}};
        int[][] res = obj.matrixReshape(mat, 1, 4);

        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
