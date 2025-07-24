/**
 * Problem: Maximum Value of a String in an Array
 * Difficulty: Easy
 *
 * A string's value is defined as:
 * - Its numeric value if it contains digits only
 * - Otherwise, its length
 * Return the maximum value among all strings in the array.
 */

public class MaximumValueString {

    public int maximumValue(String[] strs) {
        int maxValue = 0;

        for (String str : strs) {
            int value;

            if (isNumeric(str)) {
                value = Integer.parseInt(str);
            } else {
                value = str.length();
            }

            maxValue = Math.max(maxValue, value);
        }

        return maxValue;
    }

    private boolean isNumeric(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MaximumValueString solution = new MaximumValueString();

        String[] test1 = {"alic3", "bob", "3", "4", "00000"};
        System.out.println(solution.maximumValue(test1)); // Output: 5

        String[] test2 = {"1", "01", "001", "0001"};
        System.out.println(solution.maximumValue(test2)); // Output: 1
    }
}
