/*
 add solution for count tested devices after test operations using optimized approach
*/

/**
 * Problem: Count Tested Devices After Test Operations
 * Difficulty: Easy
 *
 * Description:
 * This class calculates how many devices will be tested based on given battery percentages.
 *
 * Approach:
 * - Instead of modifying the array, we track how many times batteries would have been reduced.
 * - Use a variable `count` to represent how many tests have already happened.
 * - For each device:
 *      If batteryPercentages[i] - count > 0 → it can still be tested
 *      Increment count
 *
 * Why it works:
 * Each successful test reduces future devices by 1,
 * so we simulate this effect using `count` instead of modifying the array.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class CountTestedDevices {

    public int countTestedDevices(int[] batteryPercentages) {
        int count = 0;

        for (int i = 0; i < batteryPercentages.length; i++) {
            if (batteryPercentages[i] - count > 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountTestedDevices obj = new CountTestedDevices();

        // Example 1
        int[] arr1 = {1, 1, 2, 1, 3};
        System.out.println("Output 1: " + obj.countTestedDevices(arr1)); // 3

        // Example 2
        int[] arr2 = {0, 1, 2};
        System.out.println("Output 2: " + obj.countTestedDevices(arr2)); // 2
    }
}