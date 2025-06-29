/**
 * Problem: Cells with Odd Values in a Matrix
 * Difficulty: Easy
 *
 * You are given a matrix with all 0's and a list of indices.
 * For each [ri, ci] in indices, increment all cells in row ri and column ci.
 * Return the count of cells with odd values after all operations.
 */

public class OddCellsInMatrix {
    public int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];

        // Count the number of increments for each row and column
        for (int[] index : indices) {
            rows[index[0]]++;
            cols[index[1]]++;
        }

        int oddCount = 0;

        // Compute final cell values and count odds
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((rows[i] + cols[j]) % 2 == 1) {
                    oddCount++;
                }
            }
        }

        return oddCount;
    }

    public static void main(String[] args) {
        OddCellsInMatrix solution = new OddCellsInMatrix();

        int[][] indices1 = {{0, 1}, {1, 1}};
        int[][] indices2 = {{1, 1}, {0, 0}};

        System.out.println(solution.oddCells(2, 3, indices1)); // Output: 6
        System.out.println(solution.oddCells(2, 2, indices2)); // Output: 0
    }
}
