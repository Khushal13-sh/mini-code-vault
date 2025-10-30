/**
 * Problem: Check if Any Element Has Prime Frequency
 * Difficulty: Easy
 *
 * Description:
 * Given an integer array nums, return true if the frequency of any element 
 * in the array is a prime number; otherwise, return false.
 *
 * Example 1:
 * Input: nums = [1,2,3,4,5,4]
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,2,3,4,5]
 * Output: false
 *
 * Example 3:
 * Input: nums = [2,2,2,4,4]
 * Output: true
 */

public class CheckPrimeFrequency {

    public boolean checkPrimeFrequency(int[] nums) {
        int[] unique = new int[nums.length];
        int[] freq = new int[nums.length];
        int size = 0;

        for (int i = 0; i < nums.length; i++) {
            int j;
            for (j = 0; j < size; j++) {
                if (unique[j] == nums[i]) {
                    freq[j]++;
                    break;
                }
            }
            if (j == size) {
                unique[size] = nums[i];
                freq[size] = 1;
                size++;
            }
        }

        for (int i = 0; i < size; i++) {
            if (isPrime(freq[i])) return true;
        }
        return false;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // main method for testing
    public static void main(String[] args) {
        CheckPrimeFrequency sol = new CheckPrimeFrequency();

        System.out.println(sol.checkPrimeFrequency(new int[]{1, 2, 3, 4, 5, 4})); // true
        System.out.println(sol.checkPrimeFrequency(new int[]{1, 2, 3, 4, 5}));     // false
        System.out.println(sol.checkPrimeFrequency(new int[]{2, 2, 2, 4, 4}));     // true
    }
}
