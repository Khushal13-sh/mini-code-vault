/**
 * Problem: Unique 3-Digit Even Numbers
 * Difficulty: Easy
 *
 * Given an array of digits, find how many distinct 3-digit even numbers
 * can be formed without leading zeros and without reusing digits more than available.
 */
public class Solution {
    public int totalNumbers(int[] digits) {
        // Frequency of each digit in the input
        int[] count = new int[10];
        for (int d : digits) count[d]++;

        int total = 0;

        // Loop through all possible 3-digit even numbers
        for (int num = 100; num <= 998; num += 2) {
            int a = num / 100;         // hundreds place
            int b = (num / 10) % 10;   // tens place
            int c = num % 10;          // ones place (even)

            // Frequency of digits used in current number
            int[] freq = new int[10];
            freq[a]++; freq[b]++; freq[c]++;

            boolean canForm = true;
            for (int i = 0; i < 10; i++) {
                if (freq[i] > count[i]) {
                    canForm = false;
                    break;
                }
            }

            if (canForm) total++;
        }

        return total;
    }

    // --- test ---
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.totalNumbers(new int[]{1, 2, 3, 4})); // 12
        System.out.println(sol.totalNumbers(new int[]{0, 2, 2}));     // 2
        System.out.println(sol.totalNumbers(new int[]{6, 6, 6}));     // 1
        System.out.println(sol.totalNumbers(new int[]{1, 3, 5}));     // 0
    }
}
