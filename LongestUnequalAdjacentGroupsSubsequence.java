import java.util.ArrayList;
import java.util.List;

/**
 * ------------------------------------------------------------
 * Class Name : LongestUnequalAdjacentGroupsSubsequence
 *
 * Description :
 * Returns the longest subsequence of words such that
 * adjacent selected words belong to different groups.
 *
 * ------------------------------------------------------------
 */
public class LongestUnequalAdjacentGroupsSubsequence {

    /**
     * Returns the longest alternating subsequence of words.
     */
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();

        // Always include the first word
        result.add(words[0]);
        int lastGroup = groups[0];

        // Select words with alternating group values
        for (int i = 1; i < words.length; i++) {
            if (groups[i] != lastGroup) {
                result.add(words[i]);
                lastGroup = groups[i];
            }
        }

        return result;
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {
        LongestUnequalAdjacentGroupsSubsequence solution =
                new LongestUnequalAdjacentGroupsSubsequence();

        String[] words1 = {"e", "a", "b"};
        int[] groups1 = {0, 0, 1};
        System.out.println(solution.getLongestSubsequence(words1, groups1));

        String[] words2 = {"a", "b", "c", "d"};
        int[] groups2 = {1, 0, 1, 1};
        System.out.println(solution.getLongestSubsequence(words2, groups2));
    }
}
