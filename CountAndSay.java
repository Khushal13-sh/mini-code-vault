/*
 add solution for count and say
*/

/**
 * Problem: Count and Say
 * Difficulty: Medium
 *
 * Description:
 * Given a positive integer n, return the nth element
 * of the Count and Say sequence.
 *
 * Each new element is created by describing the
 * consecutive groups of digits in the previous element.
 *
 * Key Insight:
 * - Start with "1".
 * - For every next sequence, count consecutive
 *   identical characters.
 * - Append the count followed by the character.
 *
 * Approach:
 * - Use a StringBuilder to construct each new sequence.
 * - Traverse the previous result character by character.
 * - Keep track of consecutive character counts.
 *
 * Time Complexity: O(n * m)
 * where m is the length of the generated string.
 *
 * Space Complexity: O(m)
 * for storing the newly generated string.
 */
public class CountAndSay {

    public String countAndSay(int n) {

        // First element of the sequence.
        String result = "1";

        // Generate the remaining n - 1 elements.
        for (int i = 1; i < n; i++) {

            StringBuilder current = new StringBuilder();

            int count = 1;

            // Traverse the current sequence.
            for (int j = 1; j < result.length(); j++) {

                // If the current character is the same
                // as the previous character, increase count.
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;

                } else {

                    // Store the count followed by the character.
                    current.append(count);
                    current.append(result.charAt(j - 1));

                    // Start counting the new group.
                    count = 1;
                }
            }

            // Add the final group.
            current.append(count);
            current.append(result.charAt(result.length() - 1));

            // Move to the next sequence.
            result = current.toString();
        }

        return result;
    }

    public static void main(String[] args) {

        CountAndSay obj = new CountAndSay();

        // Example 1
        int n1 = 4;
        String result1 = obj.countAndSay(n1);

        System.out.println("Input 1: n = " + n1);
        System.out.println("Output 1: " + result1);

        // Example 2
        int n2 = 1;
        String result2 = obj.countAndSay(n2);

        System.out.println("Input 2: n = " + n2);
        System.out.println("Output 2: " + result2);
    }
}