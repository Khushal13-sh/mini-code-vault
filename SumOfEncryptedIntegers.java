/**
 * Problem: Find the Sum of Encrypted Integers
 * Difficulty: Easy
 *
 * Each number is encrypted by replacing all its digits
 * with the largest digit from that number.
 * Return the sum of all encrypted numbers.
 */

public class SumOfEncryptedIntegers {

    public int sumOfEncryptedInt(int[] nums) {
        int total = 0;

        for (int num : nums) {

            int temp = num;
            int largestDigit = 0;
            int digitCount = 0;

            // Find largest digit and count digits
            while (temp > 0) {
                int digit = temp % 10;
                if (digit > largestDigit) {
                    largestDigit = digit;
                }
                digitCount++;
                temp = temp / 10;
            }

            // Build encrypted number with repeated largest digit
            int encrypted = 0;
            for (int i = 0; i < digitCount; i++) {
                encrypted = encrypted * 10 + largestDigit;
            }

            total += encrypted;
        }

        return total;
    }

    // ------------ MAIN METHOD FOR TESTING ------------
    public static void main(String[] args) {
        SumOfEncryptedIntegers sol = new SumOfEncryptedIntegers();

        System.out.println(sol.sumOfEncryptedInt(new int[]{1, 2, 3}));         // 6
        System.out.println(sol.sumOfEncryptedInt(new int[]{10, 21, 31}));      // 66
        System.out.println(sol.sumOfEncryptedInt(new int[]{523, 213}));        // 888 (555 + 333)
        System.out.println(sol.sumOfEncryptedInt(new int[]{9, 99, 909}));      // 9 + 99 + 999 = 1107
        System.out.println(sol.sumOfEncryptedInt(new int[]{7}));               // 7
    }
}
