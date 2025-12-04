/**
 * Problem: Make a Square with the Same Color
 * Difficulty: Easy
 *
 * Rule:
 * We need to check all 2x2 subgrids in a 3x3 grid.
 * If any has at least 3 matching colors, we can make it uniform with at most one change.
 */
public class MakeSquareWithColor {

    public boolean canMakeSquare(char[][] grid) {

        // Only 4 possible 2x2 blocks in a 3x3 grid
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {

                int countW = 0, countB = 0;

                // Count colors inside the 2x2 block
                for (int r = 0; r < 2; r++) {
                    for (int c = 0; c < 2; c++) {
                        if (grid[i + r][j + c] == 'W') countW++;
                        else countB++;
                    }
                }

                // Valid if 3 or 4 cells are the same color
                if (countW >= 3 || countB >= 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MakeSquareWithColor solution = new MakeSquareWithColor();

        System.out.println(solution.canMakeSquare(
                new char[][]{{'B','W','B'},{'B','W','W'},{'B','W','B'}})); // true

        System.out.println(solution.canMakeSquare(
                new char[][]{{'B','W','B'},{'W','B','W'},{'B','W','B'}})); // false

        System.out.println(solution.canMakeSquare(
                new char[][]{{'B','W','B'},{'B','W','W'},{'B','W','W'}})); // true
    }
}
