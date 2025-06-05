/**
 * Problem: Count Largest Group
 * Difficulty: Easy
 *
 * 🧠 Description:
 * Group numbers from 1 to n by the sum of their digits.
 * Return the number of groups that have the largest size.
 *
 * 🧪 Example:
 * Input: n = 13
 * Output: 4
 * Explanation: Groups are [1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9]
 * Largest groups (size = 2): [1,10], [2,11], [3,12], [4,13]
 */

import java.util.*;

public class CountLargestGroup {

    public static int countLargestGroup(int n) {
        int[] group = new int[37]; // Max digit sum for 9999 is 36 (9+9+9+9)
        int maxSize = 0;

        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i);
            group[sum]++;
            maxSize = Math.max(maxSize, group[sum]);
        }

        int count = 0;
        for (int g : group) {
            if (g == maxSize) {
                count++;
            }
        }

        return count;
    }

    private static int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countLargestGroup(13)); // Output: 4
        System.out.println(countLargestGroup(2));  // Output: 2
        System.out.println(countLargestGroup(24)); // Output: 5
        System.out.println(countLargestGroup(1));  // Output: 1
    }
}
