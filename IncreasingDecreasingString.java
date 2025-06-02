/**
 * Problem: Increasing Decreasing String
 * Difficulty: Easy
 *
 * 🧠 Description:
 * Reorder a given string `s` using the following algorithm:
 * 1. Pick the smallest character and append it.
 * 2. Keep picking the next smallest character greater than the last.
 * 3. Stop when no valid characters remain, then:
 * 4. Pick the largest character and append it.
 * 5. Keep picking the next largest character smaller than the last.
 * 6. Repeat until all characters are used.
 *
 * 📥 Example:
 * Input: "aaaabbbbcccc"
 * Output: "abccbaabccba"
 */

public class IncreasingDecreasingString {
    public static String sortString(String s) {
        int[] freq = new int[26]; // frequency array for 'a' to 'z'

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        int total = s.length();

        // Build result with increasing and decreasing passes
        while (sb.length() < total) {
            // Ascending a-z
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    sb.append((char) (i + 'a'));
                    freq[i]--;
                }
            }
            // Descending z-a
            for (int i = 25; i >= 0; i--) {
                if (freq[i] > 0) {
                    sb.append((char) (i + 'a'));
                    freq[i]--;
                }
            }
        }

        return sb.toString();
    }

    // 🧪 Test the solution
    public static void main(String[] args) {
        String input1 = "aaaabbbbcccc";
        String input2 = "rat";
        String input3 = "leetcode";
        String input4 = "ggggggg";
        String input5 = "spo";

        System.out.println(sortString(input1)); // Output: abccbaabccba
        System.out.println(sortString(input2)); // Output: art
        System.out.println(sortString(input3)); // Output: cdeelote (can vary)
        System.out.println(sortString(input4)); // Output: ggggggg
        System.out.println(sortString(input5)); // Output: ops
    }
}
