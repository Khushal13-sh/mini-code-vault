/**
 * Problem: Find the Key of the Numbers
 * Difficulty: Easy
 *
 * Description:
 * You are given three positive integers num1, num2, and num3.
 *
 * The "key" of num1, num2, and num3 is defined as a four-digit number such that:
 * 1. If any number has less than four digits, it is padded with leading zeros.
 * 2. For each digit position (1 <= i <= 4), the ith digit of the key is the minimum
 *    among the ith digits of num1, num2, and num3.
 * 3. The result is returned as an integer (without leading zeros).
 *
 * Example 1:
 * Input: num1 = 1, num2 = 10, num3 = 1000
 * Output: 0
 * Explanation:
 * - Padded: num1 = "0001", num2 = "0010", num3 = "1000"
 * - Digits comparison: [0,0,0,0] → Key = 0000 → 0
 *
 * Example 2:
 * Input: num1 = 987, num2 = 879, num3 = 798
 * Output: 777
 *
 * Example 3:
 * Input: num1 = 1, num2 = 2, num3 = 3
 * Output: 1
 *
 * Constraints:
 * - 1 <= num1, num2, num3 <= 9999
 *
 * Approach:
 * 1. Create a helper function `fillDigits` to convert numbers into a fixed 4-digit array.
 * 2. Compare digits at each index across the three numbers.
 * 3. Build the key using the minimum digit at each position.
 * 4. Parse the result to integer (automatically removes leading zeros).
 *
 * Time Complexity: O(1) [always 4 digits processed]
 * Space Complexity: O(1)
 */
public class FindKeyOfNumbers {

    /**
     * Generates the key based on the rules.
     *
     * @param num1 first integer
     * @param num2 second integer
     * @param num3 third integer
     * @return the key as an integer
     */
    public int generateKey(int num1, int num2, int num3) {
        int[] arr1 = fillDigits(num1);
        int[] arr2 = fillDigits(num2);
        int[] arr3 = fillDigits(num3);

        StringBuilder key = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int minDigit = Math.min(arr1[i], Math.min(arr2[i], arr3[i]));
            key.append(minDigit);
        }

        return Integer.parseInt(key.toString());
    }

    /**
     * Helper method to convert number into a 4-digit array (with leading zeros).
     */
    private int[] fillDigits(int num) {
        int[] arr = new int[4];
        for (int i = 3; i >= 0; i--) {
            arr[i] = num % 10;
            num /= 10;
        }
        return arr;
    }

    /**
     * Main method for testing.
     */
    public static void main(String[] args) {
        FindKeyOfNumbers solution = new FindKeyOfNumbers();

        System.out.println("Output (1, 10, 1000): " + solution.generateKey(1, 10, 1000)); // 0
        System.out.println("Output (987, 879, 798): " + solution.generateKey(987, 879, 798)); // 777
        System.out.println("Output (1, 2, 3): " + solution.generateKey(1, 2, 3)); // 1
    }
}
