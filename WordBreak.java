import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Problem: Word Break
 *
 * Description:
 * Given a string s and a dictionary of words, determine whether
 * the string can be segmented into one or more dictionary words.
 *
 * Dictionary words can be reused multiple times.
 *
 * Approach: Dynamic Programming (1D DP) + HashSet
 *
 * 1. Convert wordDict into a HashSet for faster word lookup.
 * 2. Create a boolean DP array of size s.length() + 1.
 * 3. dp[i] represents whether the substring from index 0
 *    to i - 1 can be segmented using dictionary words.
 * 4. Initialize dp[0] = true because an empty string
 *    can always be segmented.
 * 5. For every position i, check all previous positions j:
 *    - If dp[j] is true, check whether s.substring(j, i)
 *      exists in the dictionary.
 *    - If both conditions are satisfied, set dp[i] = true.
 * 6. Return dp[s.length()] as the final result.
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {

            for (int j = 0; j < i; j++) {

                if (dp[j] && set.contains(s.substring(j, i))) {

                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {

        WordBreak solution = new WordBreak();

        System.out.println(solution.wordBreak(
            "leetcode",
            Arrays.asList("leet", "code")
        ));

        System.out.println(solution.wordBreak(
            "applepenapple",
            Arrays.asList("apple", "pen")
        ));

        System.out.println(solution.wordBreak(
            "catsandog",
            Arrays.asList("cats", "dog", "sand", "and", "cat")
        ));
    }
}