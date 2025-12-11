/**
 * Problem: Check if Array is Good
 * Difficulty: Easy
 *
 * An array is good if it matches the structure of:
 * base[n] = [1, 2, ..., n-1, n, n]
 * 
 * Conditions:
 * - Length must be n+1
 * - Elements must be from 1 to n only
 * - Each value from 1..n-1 must appear once
 * - Value n must appear twice
 */
public class CheckIfArrayIsGood {

    public boolean isGood(int[] nums) {

        // Find maximum element (n)
        int n = 0;
        for (int x : nums) {
            n = Math.max(n, x);
        }

        // Length must be exactly n + 1
        if (nums.length != n + 1) return false;

        int[] count = new int[n + 1];

        // Count frequencies
        for (int x : nums) {
            if (x < 1 || x > n) return false;
            count[x]++;
        }

        // All numbers 1..n-1 must appear exactly once
        for (int i = 1; i < n; i++) {
            if (count[i] != 1) return false;
        }

        // Number n must appear exactly twice
        return count[n] == 2;
    }

    // ---------------- MAIN METHOD FOR TESTING ----------------
    public static void main(String[] args) {
        CheckIfArrayIsGood obj = new CheckIfArrayIsGood();

        System.out.println(obj.isGood(new int[]{2, 1, 3}));        // false
        System.out.println(obj.isGood(new int[]{1, 3, 3, 2}));    // true
        System.out.println(obj.isGood(new int[]{1, 1}));          // true
        System.out.println(obj.isGood(new int[]{3, 4, 4, 1, 2, 1})); // false
    }
}
