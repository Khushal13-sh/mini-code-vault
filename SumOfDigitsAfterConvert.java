/**
 * Problem: Sum of Digits of String After Convert
 * Difficulty: Easy
 *
 * Convert the string to a number by replacing each letter with its alphabet position.
 * Then, perform digit sum transformation 'k' times.
 */

public class SumOfDigitsAfterConvert {

    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();

        // Step 1: Convert characters to corresponding numeric position
        for (char c : s.toCharArray()) {
            sb.append(c - 'a' + 1);
        }

        // Step 2: Perform digit sum transformation k times
        String result = sb.toString();
        for (int i = 0; i < k; i++) {
            int sum = 0;
            for (char c : result.toCharArray()) {
                sum += c - '0';
            }
            result = String.valueOf(sum);
        }

        return Integer.parseInt(result);
    }

    public static void main(String[] args) {
        SumOfDigitsAfterConvert solution = new SumOfDigitsAfterConvert();

        System.out.println(solution.getLucky("iiii", 1));      // Output: 36
        System.out.println(solution.getLucky("leetcode", 2));  // Output: 6
        System.out.println(solution.getLucky("zbax", 2));      // Output: 8
    }
}
