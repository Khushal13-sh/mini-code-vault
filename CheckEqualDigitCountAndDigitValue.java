/*
 add solution for checking equal digit count and digit value
*/

/**
 * Problem: Check if Number Has Equal Digit Count and Digit Value
 * Difficulty: Easy
 *
 * Description:
 * Given a string num consisting of digits,
 * check whether for every index i, the digit i
 * occurs exactly num[i] times in the string.
 *
 * Key Insight:
 * - Count the frequency of every digit from 0 to 9.
 * - For each index i, compare its expected count
 *   with the actual frequency of digit i.
 *
 * Approach:
 * - Create a frequency array of size 10.
 * - Count the occurrences of each digit.
 * - For every index i, compare count[i] with num[i].
 * - Return false if any count does not match.
 * - Return true if all counts match.
 *
 * Why this works:
 * The frequency array stores the exact number of
 * occurrences of every digit, allowing us to directly
 * verify the condition for each index.
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(1)
 * The frequency array always has a fixed size of 10.
 */
public class CheckEqualDigitCountAndDigitValue {

    public boolean digitCount(String num) {

        int n = num.length();
        int[] count = new int[10];

        for (char ch : num.toCharArray()) {
            count[ch - '0']++;
        }

        for (int i = 0; i < n; i++) {
            int expected = num.charAt(i) - '0';

            if (count[i] != expected) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        CheckEqualDigitCountAndDigitValue obj =
                new CheckEqualDigitCountAndDigitValue();

        // Example 1
        String num1 = "1210";
        System.out.println("Output 1: " + obj.digitCount(num1));

        // Example 2
        String num2 = "030";
        System.out.println("Output 2: " + obj.digitCount(num2));
    }
}