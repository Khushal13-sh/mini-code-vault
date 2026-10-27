
/**
 * Problem: String to Integer (atoi)
 * Difficulty: Medium
 *
 * Approach:
 * Convert the string into an integer manually,
 * one digit at a time.
 *
 * Steps:
 * 1. Skip leading spaces.
 * 2. Determine the sign.
 * 3. Read consecutive digits.
 * 4. Check for integer overflow before updating the result.
 * 5. Return the signed integer.
 *
 * No built-in string-to-number conversion methods are used.
 */
public class StringToIntegerAtoi {

    public int myAtoi(String s) {

        // Current position in the string.
        int i = 0;

        // Total number of characters in the string.
        int n = s.length();

        // Step 1: Skip leading spaces.
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Assume the number is positive.
        int sign = 1;

        // Check whether the number has an explicit sign.
        if (i < n && s.charAt(i) == '-') {

            // A minus sign means the number is negative.
            sign = -1;
            i++;

        } else if (i < n && s.charAt(i) == '+') {

            // A plus sign means the number is positive.
            i++;
        }

        // Stores the numeric value without its sign.
        int result = 0;

        // Step 3: Read digits until a non-digit is found.
        while (i < n) {

            char ch = s.charAt(i);

            // Stop if the current character is not a digit.
            if (ch < '0' || ch > '9') {
                break;
            }

            // Convert the digit character into its numeric value.
            // Example: '7' - '0' gives 7.
            int digit = ch - '0';

            /*
             * Step 4: Check for overflow before updating result.
             *
             * Integer.MAX_VALUE = 2147483647
             *
             * If result is greater than 214748364, appending
             * another digit would exceed the positive limit.
             *
             * If result is exactly 214748364, the final digit
             * cannot exceed 7 for a positive 32-bit integer.
             *
             * For a negative number, a magnitude of 2147483648
             * is also allowed, but the condition below clamps it
             * directly to Integer.MIN_VALUE when digit > 7.
             * This still produces the correct final answer.
             */
            if (result > Integer.MAX_VALUE / 10 ||
                (result == Integer.MAX_VALUE / 10 && digit > 7)) {

                // Return the appropriate boundary value.
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }

            // Append the current digit to the result.
            result = result * 10 + digit;

            // Move to the next character.
            i++;
        }

        // Step 5: Apply the sign and return the result.
        return result * sign;
    }

    // Main method for testing.
    public static void main(String[] args) {

        StringToIntegerAtoi solution = new StringToIntegerAtoi();

        // Test Case 1: Positive number.
        System.out.println(solution.myAtoi("42"));
        // Expected: 42

        // Test Case 2: Leading spaces, negative sign, and zeros.
        System.out.println(solution.myAtoi(" -042"));
        // Expected: -42

        // Test Case 3: Stop at the first non-digit.
        System.out.println(solution.myAtoi("1337c0d3"));
        // Expected: 1337

        // Test Case 4: Stop when a non-digit follows the first digit.
        System.out.println(solution.myAtoi("0-1"));
        // Expected: 0

        // Test Case 5: String starts with letters.
        System.out.println(solution.myAtoi("words and 987"));
        // Expected: 0

        // Test Case 6: Positive overflow.
        System.out.println(solution.myAtoi("2147483648"));
        // Expected: 2147483647

        // Test Case 7: Negative overflow.
        System.out.println(solution.myAtoi("-2147483649"));
        // Expected: -2147483648

        // Test Case 8: Exact minimum integer.
        System.out.println(solution.myAtoi("-2147483648"));
        // Expected: -2147483648

        // Test Case 9: Only spaces.
        System.out.println(solution.myAtoi("   "));
        // Expected: 0

        // Test Case 10: Empty string.
        System.out.println(solution.myAtoi(""));
        // Expected: 0

        // Test Case 11: Decimal point stops conversion.
        System.out.println(solution.myAtoi("3.14159"));
        // Expected: 3

        // Test Case 12: Sign without digits.
        System.out.println(solution.myAtoi("+"));
        // Expected: 0
    }
}

/**
 * Problem: String to Integer (atoi)
 * Difficulty: Medium
 *
 * Approach:
 * Convert the string into an integer manually,
 * one digit at a time.
 *
 * Steps:
 * 1. Skip leading spaces.
 * 2. Determine the sign.
 * 3. Read consecutive digits.
 * 4. Check for integer overflow before updating the result.
 * 5. Return the signed integer.
 *
 * No built-in string-to-number conversion methods are used.
 */
public class StringToIntegerAtoi {

    public int myAtoi(String s) {

        // Current position in the string.
        int i = 0;

        // Total number of characters in the string.
        int n = s.length();

        // Step 1: Skip leading spaces.
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Assume the number is positive.
        int sign = 1;

        // Check whether the number has an explicit sign.
        if (i < n && s.charAt(i) == '-') {

            // A minus sign means the number is negative.
            sign = -1;
            i++;

        } else if (i < n && s.charAt(i) == '+') {

            // A plus sign means the number is positive.
            i++;
        }

        // Stores the numeric value without its sign.
        int result = 0;

        // Step 3: Read digits until a non-digit is found.
        while (i < n) {

            char ch = s.charAt(i);

            // Stop if the current character is not a digit.
            if (ch < '0' || ch > '9') {
                break;
            }

            // Convert the digit character into its numeric value.
            // Example: '7' - '0' gives 7.
            int digit = ch - '0';

            /*
             * Step 4: Check for overflow before updating result.
             *
             * Integer.MAX_VALUE = 2147483647
             *
             * If result is greater than 214748364, appending
             * another digit would exceed the positive limit.
             *
             * If result is exactly 214748364, the final digit
             * cannot exceed 7 for a positive 32-bit integer.
             *
             * For a negative number, a magnitude of 2147483648
             * is also allowed, but the condition below clamps it
             * directly to Integer.MIN_VALUE when digit > 7.
             * This still produces the correct final answer.
             */
            if (result > Integer.MAX_VALUE / 10 ||
                (result == Integer.MAX_VALUE / 10 && digit > 7)) {

                // Return the appropriate boundary value.
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }

            // Append the current digit to the result.
            result = result * 10 + digit;

            // Move to the next character.
            i++;
        }

        // Step 5: Apply the sign and return the result.
        return result * sign;
    }

    // Main method for testing.
    public static void main(String[] args) {

        StringToIntegerAtoi solution = new StringToIntegerAtoi();

        // Test Case 1: Positive number.
        System.out.println(solution.myAtoi("42"));
        // Expected: 42

        // Test Case 2: Leading spaces, negative sign, and zeros.
        System.out.println(solution.myAtoi(" -042"));
        // Expected: -42

        // Test Case 3: Stop at the first non-digit.
        System.out.println(solution.myAtoi("1337c0d3"));
        // Expected: 1337

        // Test Case 4: Stop when a non-digit follows the first digit.
        System.out.println(solution.myAtoi("0-1"));
        // Expected: 0

        // Test Case 5: String starts with letters.
        System.out.println(solution.myAtoi("words and 987"));
        // Expected: 0

        // Test Case 6: Positive overflow.
        System.out.println(solution.myAtoi("2147483648"));
        // Expected: 2147483647

        // Test Case 7: Negative overflow.
        System.out.println(solution.myAtoi("-2147483649"));
        // Expected: -2147483648

        // Test Case 8: Exact minimum integer.
        System.out.println(solution.myAtoi("-2147483648"));
        // Expected: -2147483648

        // Test Case 9: Only spaces.
        System.out.println(solution.myAtoi("   "));
        // Expected: 0

        // Test Case 10: Empty string.
        System.out.println(solution.myAtoi(""));
        // Expected: 0

        // Test Case 11: Decimal point stops conversion.
        System.out.println(solution.myAtoi("3.14159"));
        // Expected: 3

        // Test Case 12: Sign without digits.
        System.out.println(solution.myAtoi("+"));
        // Expected: 0
    }
}
