/*
 add solution for count monobit integers using bit manipulation approach
*/

/**
 * Problem: Count Monobit Integers
 * Difficulty: Easy
 *
 * Description:
 * A number is Monobit if all bits in its binary representation are the same.
 * Count how many such numbers exist in range [0, n].
 *
 * Key Insight:
 * - Valid numbers:
 *      → 0 (binary "0")
 *      → Numbers like: 1 (1), 3 (11), 7 (111), 15 (1111), ...
 * - These follow pattern: num = (num << 1) | 1
 *
 * Approach:
 * - Start with count = 1 (for number 0)
 * - Generate numbers with all 1 bits using bit manipulation
 * - Count until value exceeds n
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class CountMonobitIntegers {

    public int countMonobit(int n) {

        int count = 0;

        // Count 0
        if (n >= 0) count++;

        int num = 1;

        // Generate numbers like 1, 3, 7, 15...
        while (num <= n) {
            count++;
            num = (num << 1) | 1;
        }

        return count;
    }

    public static void main(String[] args) {
        CountMonobitIntegers obj = new CountMonobitIntegers();

        // Example 1
        int n1 = 1;
        System.out.println("Output 1: " + obj.countMonobit(n1)); // 2

        // Example 2
        int n2 = 4;
        System.out.println("Output 2: " + obj.countMonobit(n2)); // 3
    }
}