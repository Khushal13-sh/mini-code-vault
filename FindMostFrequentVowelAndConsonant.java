/**
 * Problem: Find Most Frequent Vowel and Consonant
 * Difficulty: Easy
 *
 * Given a lowercase string, find the maximum frequency among vowels and consonants,
 * then return the sum of those two frequencies.
 */
public class FindMostFrequentVowelAndConsonant {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        String vowels = "aeiou";
        int maxVowelFreq = 0;
        int maxConsonantFreq = 0;

        // Identify highest frequency vowel and consonant
        for (int i = 0; i < 26; i++) {
            char ch = (char) (i + 'a');
            if (vowels.indexOf(ch) != -1) {
                maxVowelFreq = Math.max(maxVowelFreq, freq[i]);
            } else {
                maxConsonantFreq = Math.max(maxConsonantFreq, freq[i]);
            }
        }

        return maxVowelFreq + maxConsonantFreq;
    }

    // --- test ---
    public static void main(String[] args) {
        FindMostFrequentVowelAndConsonant sol = new FindMostFrequentVowelAndConsonant();
        System.out.println(sol.maxFreqSum("abbaaaccc")); // 7
        System.out.println(sol.maxFreqSum("aeiou"));     // 5 (only vowels)
        System.out.println(sol.maxFreqSum("bcdfg"));     // 5 (only consonants)
        System.out.println(sol.maxFreqSum(""));          // 0 (empty string)
    }
}
