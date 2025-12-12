/**
 * Problem: Number of Beautiful Pairs
 * Difficulty: Easy
 *
 * Count all pairs (i, j) where the first digit of nums[i]
 * and last digit of nums[j] are coprime (gcd == 1).
 */

public class NumberOfBeautifulPairs {

    public int countBeautifulPairs(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int firstDigit = getFirstDigit(nums[i]);

            for (int j = i + 1; j < n; j++) {
                int lastDigit = nums[j] % 10;

                if (gcd(firstDigit, lastDigit) == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    // Extract first digit
    private int getFirstDigit(int num) {
        while (num >= 10) {
            num /= 10;
        }
        return num;
    }

    // Compute gcd using Euclid algorithm
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Main method for testing
    public static void main(String[] args) {
        NumberOfBeautifulPairs obj = new NumberOfBeautifulPairs();

        int[] nums1 = {2, 5, 1, 4};
        System.out.println("Output: " + obj.countBeautifulPairs(nums1)); // 5

        int[] nums2 = {11, 21, 12};
        System.out.println("Output: " + obj.countBeautifulPairs(nums2)); // 2
    }
}
