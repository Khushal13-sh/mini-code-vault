/*
 add solution for checking whether two chessboard squares have the same color
*/

/**
 * Problem: Check if Two Chessboard Squares Have the Same Color
 * Difficulty: Easy
 *
 * Description:
 * Given two chessboard coordinates, determine whether
 * both squares have the same color.
 *
 * Key Insight:
 * On a chessboard:
 *
 * - Squares with even (column + row) sum have one color.
 * - Squares with odd (column + row) sum have the other color.
 *
 * Therefore:
 * If both coordinates have the same parity,
 * they are the same color.
 *
 * Approach:
 * 1. Convert column letter to numeric value.
 * 2. Convert row character to integer.
 * 3. Compute (column + row) for both squares.
 * 4. Compare their parity.
 *
 * Why this works:
 * Chessboard colors alternate every square.
 * Parity of (row + column) uniquely determines color.
 *
 * Time Complexity: O(1)
 *
 * Space Complexity: O(1)
 */
public class CheckIfTwoChessboardSquaresHaveSameColor {

    public boolean checkTwoChessboards(String coordinate1,
                                       String coordinate2) {

        char col1 = coordinate1.charAt(0);
        char row1 = coordinate1.charAt(1);

        int colValue1 = col1 - 'a' + 1;
        int rowValue1 = row1 - '0';

        int sum1 = colValue1 + rowValue1;

        char col2 = coordinate2.charAt(0);
        char row2 = coordinate2.charAt(1);

        int colValue2 = col2 - 'a' + 1;
        int rowValue2 = row2 - '0';

        int sum2 = colValue2 + rowValue2;

        return (sum1 % 2) == (sum2 % 2);
    }

    public static void main(String[] args) {

        CheckIfTwoChessboardSquaresHaveSameColor obj =
                new CheckIfTwoChessboardSquaresHaveSameColor();

        // Example 1
        System.out.println(
                obj.checkTwoChessboards("a1", "c3")
        ); // true

        // Example 2
        System.out.println(
                obj.checkTwoChessboards("a1", "h3")
        ); // false
    }
}