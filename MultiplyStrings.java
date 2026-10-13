
/**
 * Problem: Multiply Strings
 * Difficulty: Medium
 *
 * Problem Description:
 *
 * Given two non-negative integers represented as strings,
 * return their product as a string.
 *
 * We must not convert the complete input strings into
 * integer values or use BigInteger.
 *
 * Approach:
 *
 * 1. Handle the case where either number is zero.
 * 2. Create an integer array of size n + m to store
 *    the result digits.
 * 3. Traverse both strings from right to left.
 * 4. Multiply each pair of digits.
 * 5. Add the product to the existing value at the
 *    corresponding result position.
 * 6. Store the last digit at position i + j + 1.
 * 7. Carry the remaining value to position i + j.
 * 8. Convert the result array into a string, skipping
 *    leading zeros.
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(n + m)
 *
 * Here, n and m are the lengths of the input strings.
 */
public class MultiplyStrings {

    /**
     * Multiplies two non-negative integers represented
     * as strings without converting them into numbers.
     *
     * @param num1 first non-negative integer as a string
     * @param num2 second non-negative integer as a string
     * @return product represented as a string
     */
    public String multiply(String num1, String num2) {

        // If either number is zero, the product is zero.
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int n = num1.length();
        int m = num2.length();

        // The product can contain at most n + m digits.
        int[] result = new int[n + m];

        /*
         * Traverse num1 from right to left.
         *
         * i points to the current digit in num1.
         */
        for (int i = n - 1; i >= 0; i--) {

            /*
             * Traverse num2 from right to left.
             *
             * j points to the current digit in num2.
             */
            for (int j = m - 1; j >= 0; j--) {

                // Convert the current character into a digit.
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                // Multiply the two individual digits.
                int product = digit1 * digit2;

                /*
                 * Add the product to the value already
                 * stored at the current result position.
                 *
                 * The lower position stores the current digit.
                 * The position before it stores the carry.
                 */
                int sum = product + result[i + j + 1];

                // Store the ones digit.
                result[i + j + 1] = sum % 10;

                // Add the carry to the previous position.
                result[i + j] += sum / 10;
            }
        }

        // Build the final answer from the result array.
        StringBuilder answer = new StringBuilder();

        for (int digit : result) {

            /*
             * Skip leading zeros.
             *
             * Once the first non-zero digit is appended,
             * all following digits are included.
             */
            if (answer.length() == 0 && digit == 0) {
                continue;
            }

            answer.append(digit);
        }

        return answer.toString();
    }

    /**
     * Tests the multiply method.
     */
    public static void main(String[] args) {

        MultiplyStrings solution = new MultiplyStrings();

        // Example 1
        System.out.println(solution.multiply("2", "3"));
        // Output: 6

        // Example 2
        System.out.println(solution.multiply("123", "456"));
        // Output: 56088

        // Example 3: Multiplication by zero
        System.out.println(solution.multiply("0", "12345"));
        // Output: 0

        // Example 4: Multiplication by one
        System.out.println(solution.multiply("1", "9876"));
        // Output: 9876

        // Example 5: Carry handling
        System.out.println(solution.multiply("99", "99"));
        // Output: 9801

        // Example 6: Larger numbers
        System.out.println(solution.multiply("999", "999"));
        // Output: 998001
    }
}
