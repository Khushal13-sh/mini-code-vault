/**
 * Problem: Count Prefix and Suffix Pairs I
 * Difficulty: Easy
 *
 * Rule:
 * Count pairs (i, j) where i < j and words[i]
 * is both prefix and suffix of words[j].
 */
public class CountPrefixSuffixPairs {

    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {

                // Check prefix and suffix
                if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountPrefixSuffixPairs solution = new CountPrefixSuffixPairs();

        System.out.println(solution.countPrefixSuffixPairs(new String[]{"a","aba","ababa","aa"})); // 4
        System.out.println(solution.countPrefixSuffixPairs(new String[]{"pa","papa","ma","mama"})); // 2
        System.out.println(solution.countPrefixSuffixPairs(new String[]{"abab","ab"}));            // 0
    }
}
