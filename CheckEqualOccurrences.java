/**
 * Problem: Check if All Characters Have Equal Number of Occurrences
 * Difficulty: Easy
 *
 * Given a string s, return true if s is a good string, or false otherwise.
 *
 * A string s is good if all the characters that appear in s 
 * have the same number of occurrences (frequency).
 *
 * Example 1:
 * Input: s = "abacbc"
 * Output: true
 * Explanation: 'a', 'b', and 'c' each occur 2 times.
 *
 * Example 2:
 * Input: s = "aaabb"
 * Output: false
 * Explanation: 'a' occurs 3 times, but 'b' occurs 2 times → not equal.
 *
 * Constraints:
 * - 1 <= s.length <= 1000
 * - s consists only of lowercase English letters.
 */
import java.util.*;

public class CheckEqualOccurrences {

    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        
        // Count frequency of each character
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        // Check if all frequencies are equal
        int firstFreq = -1;
        for (char c : freqMap.keySet()) {
            int freq = freqMap.get(c);
            if (firstFreq == -1) {
                firstFreq = freq;
            } else if (freq != firstFreq) {
                return false;
            }
        }
        return true; 
    }

    // Quick test
    public static void main(String[] args) {
        CheckEqualOccurrences solution = new CheckEqualOccurrences();

        System.out.println(solution.areOccurrencesEqual("abacbc")); // true
        System.out.println(solution.areOccurrencesEqual("aaabb"));  // false
    }
}
