/**
 * ------------------------------------------------------------
 * Class Name : FascinatingNumber
 *
 * Description :
 * Checks whether a 3-digit number is fascinating by concatenating
 * n, 2*n, and 3*n and verifying digits 1 to 9 appear exactly once.
 *
 * ------------------------------------------------------------
 */
public class FascinatingNumber {

    /**
     * Returns true if the number is fascinating, otherwise false.
     */
    public boolean isFascinating(int n) {
        String combined = "" + n + (2 * n) + (3 * n);

        // Must contain exactly 9 digits
        if (combined.length() != 9) {
            return false;
        }

        boolean[] seen = new boolean[10];

        for (char ch : combined.toCharArray()) {
            int digit = ch - '0';

            // No zero and no repeated digits
            if (digit == 0 || seen[digit]) {
                return false;
            }
            seen[digit] = true;
        }

        return true;
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {
        FascinatingNumber solution = new FascinatingNumber();

        int n1 = 192;
        System.out.println("Example 1 Output: " + solution.isFascinating(n1)); // true

        int n2 = 100;
        System.out.println("Example 2 Output: " + solution.isFascinating(n2)); // false
    }
}
