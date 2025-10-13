/**
 * Problem: Find The Least Frequent Digit
 * Difficulty: Easy
 *
 * Description:
 * Given an integer n, find the digit that occurs least frequently
 * in its decimal representation. If multiple digits have the same
 * frequency, choose the smallest digit.
 *
 * Example 1:
 * Input: n = 1553322
 * Output: 1
 * Explanation:
 * Digit 1 appears only once, while all others appear twice.
 *
 * Example 2:
 * Input: n = 723344511
 * Output: 2
 * Explanation:
 * Digits 7, 2, and 5 appear only once, and the smallest among them is 2.
 *
 * Approach:
 * - Convert number to positive.
 * - Count frequency of each digit using an array of size 10.
 * - Find digit with smallest frequency (if tie, choose smallest digit).
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

import java.util.*;

public class LeastFrequentDigit {

    public int getLeastFrequentDigit(int n) {
        n = Math.abs(n);
        int[] count = new int[10];

        if (n == 0) {
            count[0] = 1;
        }

        while (n > 0) {
            int d = n % 10;
            count[d]++;
            n /= 10;
        }

        int minFreq = Integer.MAX_VALUE;
        int minDigit = 0;

        for (int d = 0; d < 10; d++) {
            if (count[d] == 0) continue;
            if (count[d] < minFreq || (count[d] == minFreq && d < minDigit)) {
                minFreq = count[d];
                minDigit = d;
            }
        }

        return minDigit;
    }

    // main method for testing examples
    public static void main(String[] args) {
        LeastFrequentDigit solution = new LeastFrequentDigit();

        // Example 1
        int n1 = 1553322;
        System.out.println("Example 1 Output: " + solution.getLeastFrequentDigit(n1));
        // Expected: 1

        // Example 2
        int n2 = 723344511;
        System.out.println("Example 2 Output: " + solution.getLeastFrequentDigit(n2));
        // Expected: 2

        // Example 3
        int n3 = 100200300;
        System.out.println("Example 3 Output: " + solution.getLeastFrequentDigit(n3));
        // Expected: 1
    }
}
