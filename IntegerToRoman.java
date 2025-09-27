import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Problem: Integer to Roman
 * Difficulty: Medium
 *
 * Convert an integer to a Roman numeral.
 *
 * Roman numerals use the symbols:
 * I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000
 *
 * Rules:
 * 1. Symbols are placed from largest to smallest from left to right.
 * 2. Subtractive forms are used for 4, 9, 40, 90, 400, 900:
 *    - 4 = IV, 9 = IX, 40 = XL, 90 = XC, 400 = CD, 900 = CM
 * 3. Symbols I, X, C, M can be repeated up to 3 times consecutively.
 *
 * Example 1:
 * Input: num = 3749
 * Output: "MMMDCCXLIX"
 *
 * Example 2:
 * Input: num = 58
 * Output: "LVIII"
 *
 * Example 3:
 * Input: num = 1994
 * Output: "MCMXCIV"
 *
 * Constraints:
 * - 1 <= num <= 3999
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M"); map.put(900, "CM"); map.put(500, "D");
        map.put(400, "CD"); map.put(100, "C"); map.put(90, "XC");
        map.put(50, "L"); map.put(40, "XL"); map.put(10, "X");
        map.put(9, "IX"); map.put(5, "V"); map.put(4, "IV");
        map.put(1, "I");

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            while (num >= entry.getKey()) {
                sb.append(entry.getValue());
                num -= entry.getKey();
            }
        }
        return sb.toString();
    }

    // Main method for quick testing
    public static void main(String[] args) {
        IntegerToRoman solution = new IntegerToRoman();

        System.out.println(solution.intToRoman(3749)); // MMMDCCXLIX
        System.out.println(solution.intToRoman(58));   // LVIII
        System.out.println(solution.intToRoman(1994)); // MCMXCIV
    }
}
