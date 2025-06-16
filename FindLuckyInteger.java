/**
 * Problem: Find Lucky Integer in an Array
 * Difficulty: Easy
 *
 * 🎯 Definition:
 * A lucky integer is one whose value equals its frequency in the array.
 * Return the largest lucky integer. If none, return -1.
 *
 * 📘 Example:
 * Input: [2, 2, 3, 4]
 * Output: 2 (since 2 appears exactly 2 times)
 */

public class FindLuckyInteger {

    public static int findLucky(int[] arr) {
        // Since arr[i] is between 1 and 500, we use a frequency array of size 501
        int[] freq = new int[501];

        // Count frequency of each number
        for (int num : arr) {
            freq[num]++;
        }

        // Iterate from largest to smallest to find the largest lucky number
        for (int i = 500; i >= 1; i--) {
            if (freq[i] == i) {
                return i;
            }
        }

        return -1; // No lucky number found
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 2, 3, 4};
        System.out.println("Lucky Number: " + findLucky(arr1));  // Output: 2

        int[] arr2 = {1, 2, 2, 3, 3, 3};
        System.out.println("Lucky Number: " + findLucky(arr2));  // Output: 3

        int[] arr3 = {2, 2, 2, 3, 3};
        System.out.println("Lucky Number: " + findLucky(arr3));  // Output: -1
    }
}
