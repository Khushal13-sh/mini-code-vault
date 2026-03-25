/*
 add solution for maximum difference by remapping a digit with example execution
*/

/**
 * Problem: Maximum Difference by Remapping a Digit
 * Difficulty: Easy
 *
 * Description:
 * Given an integer, this class computes the maximum possible difference
 * between two numbers formed by remapping exactly one digit.
 *
 * Approach:
 * - For maximum value:
 *   Replace the first non-'9' digit with '9'
 * - For minimum value:
 *   Replace the first non-'0' digit with '0'
 * - Convert both results to integers and return the difference
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class MaxDifferenceByRemappingDigit {

    public int minMaxDifference(int num) {
        String s = String.valueOf(num);

        // Find digit to replace for maximum value
        char toReplaceMax = ' ';
        for (char c : s.toCharArray()) {
            if (c != '9') {
                toReplaceMax = c;
                break;
            }
        }

        String maxStr = s;
        if (toReplaceMax != ' ') {
            maxStr = s.replace(toReplaceMax, '9');
        }
        int maxVal = Integer.parseInt(maxStr);

        // Find digit to replace for minimum value
        char toReplaceMin = ' ';
        for (char c : s.toCharArray()) {
            if (c != '0') {
                toReplaceMin = c;
                break;
            }
        }

        String minStr = s;
        if (toReplaceMin != ' ') {
            minStr = s.replace(toReplaceMin, '0');
        }
        int minVal = Integer.parseInt(minStr);

        return maxVal - minVal;
    }

    public static void main(String[] args) {
        MaxDifferenceByRemappingDigit obj = new MaxDifferenceByRemappingDigit();

        // Example 1
        int num1 = 11891;
        System.out.println("Output 1: " + obj.minMaxDifference(num1)); // 99009

        // Example 2
        int num2 = 90;
        System.out.println("Output 2: " + obj.minMaxDifference(num2)); // 99
    }
}