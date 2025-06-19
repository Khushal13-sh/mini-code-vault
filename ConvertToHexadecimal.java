/**
 * Problem: Convert a Number to Hexadecimal
 * Difficulty: Easy
 *
 * 🎯 Goal:
 * Convert a 32-bit signed integer to a hexadecimal string without using built-in methods.
 * Use two’s complement representation for negative numbers.
 *
 * ✅ Key Concepts:
 * - Use bit manipulation.
 * - Right shift using **unsigned shift (`>>>`)** to handle negatives correctly.
 * - Extract the last 4 bits using `& 0xf`.
 * - Append corresponding hex character.
 *
 * 📘 Examples:
 * Input: 26    → Output: "1a"
 * Input: -1    → Output: "ffffffff"
 *
 * 🔁 Note:
 * Limit result to 8 characters max (32-bit = 8 hex digits).
 */

public class ConvertToHexadecimal {

    public static String toHex(int num) {
        if (num == 0) return "0";

        char[] hexChars = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
        };

        StringBuilder hexResult = new StringBuilder();

        while (num != 0 && hexResult.length() < 8) {
            int hexDigit = num & 0xf; // extract last 4 bits
            hexResult.append(hexChars[hexDigit]);
            num >>>= 4; // unsigned right shift to handle negatives
        }

        return hexResult.reverse().toString(); // reverse to get correct order
    }

    public static void main(String[] args) {
        System.out.println(toHex(26));   // Output: "1a"
        System.out.println(toHex(-1));   // Output: "ffffffff"
        System.out.println(toHex(0));    // Output: "0"
        System.out.println(toHex(255));  // Output: "ff"
        System.out.println(toHex(16));   // Output: "10"
    }
}
