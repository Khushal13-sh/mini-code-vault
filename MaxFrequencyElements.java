/*
 add solution for count elements with maximum frequency using frequency array
*/

/**
 * Problem: Count Elements With Maximum Frequency
 * Difficulty: Easy
 *
 * Description:
 * Given an array, return the total count of elements that have the highest frequency.
 *
 * Approach:
 * - Use a frequency array to count occurrences of each number
 * - Find the maximum frequency
 * - Sum all frequencies equal to the maximum frequency
 *
 * Example:
 * nums = [1,2,2,3,1,4]
 * → freq of 1 = 2, freq of 2 = 2 → maxFreq = 2
 * → total = 2 + 2 = 4
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) (fixed size array)
 */
public class MaxFrequencyElements {

    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];

        // Count frequencies
        for (int num : nums) {
            freq[num]++;
        }

        // Find maximum frequency
        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        // Sum all elements having max frequency
        int result = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                result += f;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaxFrequencyElements obj = new MaxFrequencyElements();

        // Example 1
        int[] nums1 = {1, 2, 2, 3, 1, 4};
        System.out.println("Output 1: " + obj.maxFrequencyElements(nums1)); // 4

        // Example 2
        int[] nums2 = {1, 2, 3, 4, 5};
        System.out.println("Output 2: " + obj.maxFrequencyElements(nums2)); // 5
    }
}