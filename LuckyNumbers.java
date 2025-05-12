/**
 * Problem Title: Lucky Numbers in a Matrix
 * Difficulty: Easy
 * 
 * ✅ Problem Description:
 * Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix 
 * in any order. 
 * 
 * A lucky number is an element that is:
 * - The **minimum element** in its row.
 * - The **maximum element** in its column.
 * 
 * 📥 Example 1:
 * Input:  matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * Output: [15]
 * Explanation:
 * - 15 is the minimum in its row (3rd row) and the maximum in its column (1st column).
 * 
 * 📥 Example 2:
 * Input:  matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * Output: [12]
 * Explanation:
 * - 12 is the minimum in its row (3rd row) and the maximum in its column (4th column).
 * 
 * 📥 Example 3:
 * Input:  matrix = [[7,8],[1,2]]
 * Output: [7]
 * Explanation:
 * - 7 is the minimum in its row (1st row) and the maximum in its column (1st column).
 * 
 * 📌 Constraints:
 * - m == matrix.length
 * - n == matrix[i].length
 * - 1 <= n, m <= 50
 * - 1 <= matrix[i][j] <= 10^5
 * - All elements are distinct.
 */

import java.util.*;

public class LuckyNumbers {

    /**
     * 🧠 Logic:
     * - Iterate through each row to find the minimum element and its column index.
     * - Check whether this minimum element is the maximum element in that column.
     * - If yes, add it to the result list.
     */
    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        for (int i = 0; i < rowLen; i++) {
            int minCol = 0;

            // Find the minimum element in the current row
            for (int j = 1; j < colLen; j++) {
                if (matrix[i][j] < matrix[i][minCol]) {
                    minCol = j;
                }
            }

            int minVal = matrix[i][minCol];
            boolean isLucky = true;

            // Check if the minimum element is also the maximum in its column
            for (int k = 0; k < rowLen; k++) {
                if (matrix[k][minCol] > minVal) {
                    isLucky = false;
                    break;
                }
            }

            // Add the lucky number to the list if conditions are met
            if (isLucky) {
                luckyNumbers.add(minVal);
            }
        }
        return luckyNumbers;
    }

    // 🧪 Main method to test the logic
    public static void main(String[] args) {
        int[][] matrix1 = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        System.out.println("Lucky Numbers: " + luckyNumbers(matrix1));  // Expected: [15]

        int[][] matrix2 = {{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};
        System.out.println("Lucky Numbers: " + luckyNumbers(matrix2));  // Expected: [12]

        int[][] matrix3 = {{7, 8}, {1, 2}};
        System.out.println("Lucky Numbers: " + luckyNumbers(matrix3));  // Expected: [7]
    }
}
