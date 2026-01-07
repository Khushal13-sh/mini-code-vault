/**
 * Problem: Maximum Product of Two Digits
 * Difficulty: Easy
 *
 * Find the maximum product of any two digits
 * present in the given integer.
 */
public class MaximumProductOfTwoDigits {

    public int maxProduct(int n) {

        int max1 = 0;
        int max2 = 0;

        while (n > 0) {
            int digit = n % 10;
            n /= 10;

            if (digit > max1) {
                max2 = max1;
                max1 = digit;
            } else if (digit > max2) {
                max2 = digit;
            }
        }

        return max1 * max2;
    }

    // Main method for testing
    public static void main(String[] args) {
        MaximumProductOfTwoDigits obj =
                new MaximumProductOfTwoDigits();

        System.out.println(obj.maxProduct(31));   // 3
        System.out.println(obj.maxProduct(22));   // 4
        System.out.println(obj.maxProduct(124));  // 8
    }
}
