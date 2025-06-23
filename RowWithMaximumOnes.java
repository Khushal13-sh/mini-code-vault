/**
 * Problem: Row With Maximum Ones
 * Difficulty: Easy
 *
 * Given a binary matrix `mat`, return the index of the row that has the maximum number of 1s
 * and the number of 1s in that row.
 * If multiple rows have the same count, return the one with the smallest index.
 */

public class RowWithMaximumOnes {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] ans = new int[2]; // ans[0] = row index, ans[1] = number of ones

        for (int i = 0; i < mat.length; i++) {
            int oneCount = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    oneCount++;
                }
            }
            if (oneCount > ans[1]) {
                ans[0] = i;
                ans[1] = oneCount;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        RowWithMaximumOnes solution = new RowWithMaximumOnes();

        int[][] mat1 = {{0, 1}, {1, 0}};
        int[][] mat2 = {{0, 0, 0}, {0, 1, 1}};
        int[][] mat3 = {{0, 0}, {1, 1}, {0, 0}};

        printResult(solution.rowAndMaximumOnes(mat1)); // Output: [0,1]
        printResult(solution.rowAndMaximumOnes(mat2)); // Output: [1,2]
        printResult(solution.rowAndMaximumOnes(mat3)); // Output: [1,2]
    }

    private static void printResult(int[] result) {
        System.out.println("Row: " + result[0] + ", Count of 1s: " + result[1]);
    }
}
