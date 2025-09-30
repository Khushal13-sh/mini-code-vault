/**
 * Problem: Excel Sheet Column Title
 * Difficulty: Easy
 *
 * Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
 *
 * Mapping:
 * A -> 1, B -> 2, ..., Z -> 26
 * AA -> 27, AB -> 28, ..., AZ -> 52
 *
 * Example 1:
 * Input: columnNumber = 1
 * Output: "A"
 *
 * Example 2:
 * Input: columnNumber = 28
 * Output: "AB"
 *
 * Example 3:
 * Input: columnNumber = 701
 * Output: "ZY"
 *
 * Constraints:
 * - 1 <= columnNumber <= 2^31 - 1
 *
 * Approach:
 * - Treat the column number like a base-26 numeral system, but shifted (1 → A, not 0 → A).
 * - Handle the case when remainder = 0 (Z) by subtracting 1 from the quotient.
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            int remainder = columnNumber % 26;

            if (remainder == 0) {
                sb.append('Z');
                columnNumber = columnNumber / 26 - 1;
            } else {
                sb.append((char) ('A' + remainder - 1));
                columnNumber = columnNumber / 26;
            }
        }

        return sb.reverse().toString();
    }

    // Test cases
    public static void main(String[] args) {
        ExcelSheetColumnTitle solution = new ExcelSheetColumnTitle();

        System.out.println("Input: 1  -> Output: " + solution.convertToTitle(1));    // A
        System.out.println("Input: 28 -> Output: " + solution.convertToTitle(28));   // AB
        System.out.println("Input: 701 -> Output: " + solution.convertToTitle(701)); // ZY
        System.out.println("Input: 52 -> Output: " + solution.convertToTitle(52));   // AZ
    }
}
