
/*
 * Problem: Search a 2D Matrix
 * LeetCode: 74
 * Difficulty: Medium
 *
 * Approach: Binary Search
 *
 * We treat the complete 2D matrix as a virtual 1D sorted array.
 *
 * Instead of converting the matrix into an actual 1D array,
 * we calculate the corresponding row and column using:
 *
 * row = mid / numberOfColumns
 * col = mid % numberOfColumns
 *
 * If the middle element matches the target, return true.
 * Otherwise, adjust the binary search range.
 *
 * Time Complexity: O(log(m * n))
 * Space Complexity: O(1)
 */

public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        // Get the number of rows and columns.
        int m = matrix.length;
        int n = matrix[0].length;

        // Consider the matrix as a virtual 1D array.
        int left = 0;
        int right = (m * n) - 1;

        // Perform binary search.
        while (left <= right) {

            // Calculate the middle index.
            int mid = left + (right - left) / 2;

            // Convert the 1D index into 2D coordinates.
            int row = mid / n;
            int col = mid % n;

            // Get the current matrix element.
            int current = matrix[row][col];

            // Target found.
            if (current == target) {
                return true;
            }

            // Target is greater, search the right half.
            else if (current < target) {
                left = mid + 1;
            }

            // Target is smaller, search the left half.
            else {
                right = mid - 1;
            }
        }

        // Target does not exist in the matrix.
        return false;
    }

    public static void main(String[] args) {

        SearchA2DMatrix solution = new SearchA2DMatrix();

        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        // Test Case 1
        System.out.println(
            solution.searchMatrix(matrix, 3)
        ); // true

        // Test Case 2
        System.out.println(
            solution.searchMatrix(matrix, 13)
        ); // false

        // Test Case 3
        System.out.println(
            solution.searchMatrix(matrix, 60)
        ); // true

        // Test Case 4
        System.out.println(
            solution.searchMatrix(matrix, 1)
        ); // true

        // Test Case 5
        System.out.println(
            solution.searchMatrix(matrix, 25)
        ); // false
    }
}
