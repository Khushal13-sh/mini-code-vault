import java.util.ArrayList;
import java.util.List;

/*
 * Problem: Restore IP Addresses
 *
 * Description:
 * Given a string containing only digits, generate all possible valid
 * IP addresses by inserting exactly three dots into the string.
 *
 * A valid IP address contains exactly four segments.
 * Each segment must:
 * 1. Contain between 1 and 3 digits.
 * 2. Have a value between 0 and 255.
 * 3. Not contain leading zeros unless the segment is "0".
 *
 * Approach: Backtracking
 * Try creating segments of length 1, 2, and 3.
 * Validate each segment before adding it to the current list.
 * Once four segments are created, add the IP address only if
 * the entire input string has been used.
 */
public class RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        backtrack(s, 0, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(String s, int index, int count,
                           List<String> segments,
                           List<String> result) {

        if (count == 4) {
            if (index == s.length()) {
                result.add(String.join(".", segments));
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {

            if (index + i > s.length()) {
                break;
            }

            String part = s.substring(index, index + i);

            // Reject segments with leading zeros.
            if (part.length() > 1 && part.charAt(0) == '0') {
                break;
            }

            int num = Integer.parseInt(part);

            // A valid IP segment cannot exceed 255.
            if (num > 255) {
                continue;
            }

            segments.add(part);

            backtrack(s, index + i, count + 1, segments, result);

            // Backtrack by removing the last segment.
            segments.remove(segments.size() - 1);
        }
    }

    public static void main(String[] args) {

        RestoreIPAddresses solution = new RestoreIPAddresses();

        System.out.println(solution.restoreIpAddresses("25525511135"));
        System.out.println(solution.restoreIpAddresses("0000"));
        System.out.println(solution.restoreIpAddresses("101023"));
    }
}