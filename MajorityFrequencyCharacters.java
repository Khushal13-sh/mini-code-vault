/**
 * Problem: Majority Frequency Characters
 * Difficulty: Easy
 *
 * Description:
 * Given a string s of lowercase English letters, group characters by their frequency.
 * Find the frequency group that contains the largest number of distinct characters.
 * If there is a tie, choose the group with the higher frequency value.
 *
 * Return a string containing all characters from that majority frequency group (any order).
 *
 * Example:
 * Input: s = "aaabbbccdddde"
 * Output: "ab"
 *
 * Approach:
 * - Count frequency of each character.
 * - Count how many distinct characters have each frequency.
 * - Identify the frequency group with:
 *   (1) Maximum number of distinct characters.
 *   (2) If tied, higher frequency.
 * - Collect and return characters from that frequency group.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class MajorityFrequencyCharacters {

    public String majorityFrequencyGroup(String s) {
        int[] freq = new int[26]; // frequency of each character

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int[] countOfFreq = new int[s.length() + 1];
        for (int f : freq) {
            if (f > 0) countOfFreq[f]++;
        }

        int maxGroupSize = 0;
        int majorityFreq = 0;

        for (int i = 1; i < countOfFreq.length; i++) {
            if (countOfFreq[i] > maxGroupSize || 
               (countOfFreq[i] == maxGroupSize && i > majorityFreq)) {
                maxGroupSize = countOfFreq[i];
                majorityFreq = i;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (freq[i] == majorityFreq) {
                result.append((char) (i + 'a'));
            }
        }

        return result.toString();
    }

    // main method to test examples
    public static void main(String[] args) {
        MajorityFrequencyCharacters solution = new MajorityFrequencyCharacters();

        // Example 1
        String s1 = "aaabbbccdddde";
        System.out.println("Example 1 Output: " + solution.majorityFrequencyGroup(s1));
        // Expected: "ab"

        // Example 2
        String s2 = "abcd";
        System.out.println("Example 2 Output: " + solution.majorityFrequencyGroup(s2));
        // Expected: "abcd"

        // Example 3
        String s3 = "pfpfgi";
        System.out.println("Example 3 Output: " + solution.majorityFrequencyGroup(s3));
        // Expected: "fp"
    }
}
