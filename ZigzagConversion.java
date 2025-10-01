/**
 * Problem: Zigzag Conversion
 * Difficulty: Medium
 *
 * Given a string s and number of rows, arrange characters in a zigzag pattern
 * and then read them row by row.
 *
 * Example:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Zigzag:
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * Output: "PAHNAPLSIIGYIR"
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * 1 <= numRows <= 1000
 */
public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s; // No zigzag needed
        }

        StringBuilder result = new StringBuilder();
        int cycle = 2 * numRows - 2; // Full cycle length (down + diagonal up)

        for (int row = 0; row < numRows; row++) {
            for (int j = row; j < s.length(); j += cycle) {
                // Vertical characters
                result.append(s.charAt(j));

                // Diagonal characters (only for middle rows)
                int diagIndex = j + cycle - 2 * row;
                if (row > 0 && row < numRows - 1 && diagIndex < s.length()) {
                    result.append(s.charAt(diagIndex));
                }
            }
        }

        return result.toString();
    }

    // Test cases
    public static void main(String[] args) {
        ZigzagConversion solution = new ZigzagConversion();

        System.out.println("Input: PAYPALISHIRING, Rows=3 -> " + solution.convert("PAYPALISHIRING", 3));
        // Output: "PAHNAPLSIIGYIR"

        System.out.println("Input: PAYPALISHIRING, Rows=4 -> " + solution.convert("PAYPALISHIRING", 4));
        // Output: "PINALSIGYAHRPI"

        System.out.println("Input: A, Rows=1 -> " + solution.convert("A", 1));
        // Output: "A"
    }
}
