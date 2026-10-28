
/**
 * Problem: Add Binary
 * Difficulty: Easy
 *
 * Approach:
 * Add the two binary strings digit by digit,
 * starting from their rightmost characters.
 *
 * Use a carry to handle binary addition.
 * Build the result in reverse order and reverse it
 * at the end.
 *
 * No conversion of the complete strings to integers
 * is required.
 */
public class AddBinary {

    public String addBinary(String a, String b) {

        // Stores the answer in reverse order initially.
        StringBuilder result = new StringBuilder();

        // Start at the rightmost digit of each string.
        int i = a.length() - 1;
        int j = b.length() - 1;

        // Stores the carry from the previous addition.
        int carry = 0;

        // Continue while digits remain in either string
        // or a carry still needs to be added.
        while (i >= 0 || j >= 0 || carry > 0) {

            // Begin with the carry from the previous step.
            int sum = carry;

            // Add the current digit from string a, if available.
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            // Add the current digit from string b, if available.
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            // The binary result digit is the remainder after
            // dividing the sum by 2.
            result.append(sum % 2);

            // The next carry is the integer quotient after
            // dividing the sum by 2.
            carry = sum / 2;
        }

        // Digits were added from right to left,
        // so reverse the result to get the correct order.
        return result.reverse().toString();
    }

    // Main method for testing.
    public static void main(String[] args) {

        AddBinary solution = new AddBinary();

        // Test Case 1: Simple addition.
        System.out.println(solution.addBinary("11", "1"));
        // Expected: 100

        // Test Case 2: Addition with multiple carries.
        System.out.println(solution.addBinary("1010", "1011"));
        // Expected: 10101

        // Test Case 3: Both strings contain zero.
        System.out.println(solution.addBinary("0", "0"));
        // Expected: 0

        // Test Case 4: No carry is required.
        System.out.println(solution.addBinary("100", "1"));
        // Expected: 101

        // Test Case 5: Different string lengths.
        System.out.println(solution.addBinary("1", "1111"));
        // Expected: 10000

        // Test Case 6: Final carry creates a new digit.
        System.out.println(solution.addBinary("111", "1"));
        // Expected: 1000
    }
}
