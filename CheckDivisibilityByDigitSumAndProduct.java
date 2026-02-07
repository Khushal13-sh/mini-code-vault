/**
 * ------------------------------------------------------------
 * Class Name : CheckDivisibilityByDigitSumAndProduct
 *
 * Description :
 * Checks whether a number is divisible by the
 * sum of its digit sum and digit product.
 *
 * ------------------------------------------------------------
 */
public class CheckDivisibilityByDigitSumAndProduct {

    /**
     * Returns true if n is divisible by (digit sum + digit product).
     */
    public boolean checkDivisibility(int n) {
        int digitSum = 0;
        int digitProduct = 1;
        int temp = n;

        // Calculate digit sum and product
        while (temp > 0) {
            int digit = temp % 10;
            digitSum += digit;
            digitProduct *= digit;
            temp /= 10;
        }

        int total = digitSum + digitProduct;

        return n % total == 0;
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {
        CheckDivisibilityByDigitSumAndProduct solution =
                new CheckDivisibilityByDigitSumAndProduct();

        System.out.println(solution.checkDivisibility(99)); // true
        System.out.println(solution.checkDivisibility(23)); // false
    }
}
