import java.util.Arrays;

/**
 * Problem: Compute Decimal Representation
 * Difficulty: Easy
 *
 * Description:
 * Given a positive integer n, express it as a sum of base-10 components.
 * A base-10 component = (single digit 1–9) × (power of 10).
 * Return all such components in descending order.
 *
 * Example:
 * Input:  n = 537
 * Output: [500, 30, 7]
 *
 * Approach:
 * - Extract digits from the rightmost side.
 * - If the digit is non-zero, multiply by the current power of 10.
 * - Collect all base-10 components and reverse at the end.
 *
 * Time Complexity: O(log₁₀(n))
 * Space Complexity: O(1)
 */
public class ComputeDecimalRepresentation {

    public int[] decimalRepresentation(int n) {
        int[] temp = new int[10]; // stores components temporarily
        int count = 0;
        int power = 1;

        while (n > 0) {
            int digit = n % 10;
            if (digit != 0) {
                temp[count++] = digit * power;
            }
            n /= 10;
            power *= 10;
        }

        // reverse the collected components
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = temp[count - i - 1];
        }

        return result;
    }

    // Main method to test examples
    public static void main(String[] args) {
        ComputeDecimalRepresentation solution = new ComputeDecimalRepresentation();

        // Example 1
        int n1 = 537;
        System.out.println("Example 1 Output: " + Arrays.toString(solution.decimalRepresentation(n1)));
        // Expected: [500, 30, 7]

        // Example 2
        int n2 = 102;
        System.out.println("Example 2 Output: " + Arrays.toString(solution.decimalRepresentation(n2)));
        // Expected: [100, 2]

        // Example 3
        int n3 = 6;
        System.out.println("Example 3 Output: " + Arrays.toString(solution.decimalRepresentation(n3)));
        // Expected: [6]

        // Example 4 (custom)
        int n4 = 40509;
        System.out.println("Example 4 Output: " + Arrays.toString(solution.decimalRepresentation(n4)));
        // Expected: [40000, 500, 9]
    }
}
