import java.util.ArrayList;
import java.util.List;

/*
 * Problem: Palindrome Partitioning
 *
 * Description:
 * Given a string, partition it into all possible combinations
 * such that every substring in each partition is a palindrome.
 *
 * Approach: Backtracking
 * Start from index 0 and try every possible substring.
 * If the substring is a palindrome, add it to the current partition
 * and recursively process the remaining string.
 *
 * Once the entire string is processed, add a copy of the current
 * partition to the result.
 *
 * Backtrack by removing the last substring to explore other
 * possible partitions.
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();

        backtrack(s, 0, current, result);

        return result;
    }

    private void backtrack(String s, int start,
                           List<String> current,
                           List<List<String>> result) {

        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < s.length(); end++) {

            String sub = s.substring(start, end + 1);

            if (isPalindrome(sub)) {

                current.add(sub);

                backtrack(s, end + 1, current, result);

                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        PalindromePartitioning solution = new PalindromePartitioning();

        System.out.println(solution.partition("aab"));
        System.out.println(solution.partition("a"));
    }
}