/**
 * ------------------------------------------------------------
 * Class Name : FindWordsFormedByCharacters
 *
 * Description :
 * Calculates the total length of words that can be formed
 * using the given characters, where each character can be
 * used only once per word.
 *
 * ------------------------------------------------------------
 */
public class FindWordsFormedByCharacters {

    /**
     * Returns the sum of lengths of all good words.
     */
    public int countCharacters(String[] words, String chars) {

        int[] charFreq = new int[26];

        // Count frequency of available characters
        for (char c : chars.toCharArray()) {
            charFreq[c - 'a']++;
        }

        int totalLength = 0;

        // Check each word
        for (String word : words) {

            int[] tempFreq = charFreq.clone();
            boolean isGood = true;

            for (char c : word.toCharArray()) {

                tempFreq[c - 'a']--;

                if (tempFreq[c - 'a'] < 0) {
                    isGood = false;
                    break;
                }
            }

            if (isGood) {
                totalLength += word.length();
            }
        }

        return totalLength;
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {
        FindWordsFormedByCharacters solution = new FindWordsFormedByCharacters();

        String[] words1 = {"cat", "bt", "hat", "tree"};
        System.out.println(solution.countCharacters(words1, "atach")); // 6

        String[] words2 = {"hello", "world", "leetcode"};
        System.out.println(solution.countCharacters(words2, "welldonehoneyr")); // 10
    }
}
