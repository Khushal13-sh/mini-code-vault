/**
 * Problem: Smallest Divisible Digit Product I
 * Difficulty: Easy
 *
 * Goal: Find the smallest integer >= n such that
 * the product of its digits is divisible by t.
 */

public class SmallestDigitProduct {

    public int smallestNumber(int n, int t) {
        int num = n;

        // Loop until we find a valid number
        while (true) {
            if (digitProduct(num) % t == 0) {
                return num;
            }
            num++;
        }
    }

    // Helper method: calculate product of digits of a number
    private int digitProduct(int num) {
        int product = 1;

        while (num > 0) {
            int digit = num % 10;
            product *= digit;
            num /= 10;
        }

        return product;
    }

    // Test cases
    public static void main(String[] args) {
        SmallestDigitProduct solution = new SmallestDigitProduct();

        System.out.println(solution.smallestNumber(10, 2)); // Output: 10
        System.out.println(solution.smallestNumber(15, 3)); // Output: 16
        System.out.println(solution.smallestNumber(5, 5));  // Example case: Output: 5
    }
}
