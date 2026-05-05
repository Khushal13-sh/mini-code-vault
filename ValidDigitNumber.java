/*
 add solution for validating digit presence and starting condition using string conversion
*/

/**
 * Problem: Valid Digit Number
 * Difficulty: Easy
 *
 * Description:
 * A number is valid if:
 * 1. It contains at least one occurrence of digit x
 * 2. It does NOT start with digit x
 *
 * Key Insight:
 * - Convert number to string for easy digit handling
 * - Check first character condition
 * - Check presence using indexOf
 *
 * Approach:
 * - Convert integer to string
 * - Convert digit x to character
 * - If first character equals digit → return false
 * - If digit exists anywhere else → return true
 *
 * Why this works:
 * String operations simplify digit checking.
 *
 * Time Complexity: O(d)  (d = number of digits)
 * Space Complexity: O(d)
 */
public class ValidDigitNumber {

    public boolean validDigit(int n, int x) {

        String num = String.valueOf(n);
        char digit = (char) (x + '0');

        if (num.charAt(0) == digit) {
            return false;
        }

        if (num.indexOf(digit) != -1) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        ValidDigitNumber obj = new ValidDigitNumber();

        // Example 1
        System.out.println("Output 1: " + obj.validDigit(101, 0)); // true

        // Example 2
        System.out.println("Output 2: " + obj.validDigit(232, 2)); // false

        // Example 3
        System.out.println("Output 3: " + obj.validDigit(5, 1)); // false
    }
}