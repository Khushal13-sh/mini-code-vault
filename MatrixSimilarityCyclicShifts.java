/*
 add solution for matrix similarity after cyclic shifts using modular index mapping
*/

/**
 * Problem: Matrix Similarity After Cyclic Shifts
 * Difficulty: Easy
 *
 * Description:
 * Check if after k cyclic shifts:
 * - Even rows shift left
 * - Odd rows shift right
 * the matrix remains identical to the original.
 *
 * Key Insight:
 * - After n shifts → row returns to original state
 * - So reduce k using k % n
 *
 * Approach:
 * - For each element:
 *   Even row → compare with (j + k) % n
 *   Odd row  → compare with (j - k + n) % n
 *
 * Why this works:
 * Instead of actually shifting, we simulate position mapping.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(1)
 */
public class MatrixSimilarityCyclicShifts {

    public boolean areSimilar(int[][] mat, int k) {

        int m = mat.length;
        int n = mat[0].length;

        k = k % n;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (i % 2 == 0) {
                    if (mat[i][j] != mat[i][(j + k) % n]) {
                        return false;
                    }
                } else {
                    if (mat[i][j] != mat[i][(j - k + n) % n]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MatrixSimilarityCyclicShifts obj = new MatrixSimilarityCyclicShifts();

        // Example 1
        int[][] mat1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Output 1: " + obj.areSimilar(mat1, 4)); // false

        // Example 2
        int[][] mat2 = {
            {1, 2, 1, 2},
            {5, 5, 5, 5},
            {6, 3, 6, 3}
        };
        System.out.println("Output 2: " + obj.areSimilar(mat2, 2)); // true

        // Example 3
        int[][] mat3 = {
            {2, 2},
            {2, 2}
        };
        System.out.println("Output 3: " + obj.areSimilar(mat3, 3)); // true
    }
}