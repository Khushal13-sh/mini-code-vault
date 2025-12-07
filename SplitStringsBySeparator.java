/**
 * Problem: Split Strings by Separator
 * Difficulty: Easy
 *
 * Given a list of words and a separator character, split each word based on 
 * the separator and return all non-empty resulting strings in order.
 */

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();

        for (String word : words) {

            String temp = "";

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (ch == separator) {
                    if (temp.length() > 0) {
                        result.add(temp);
                    }
                    temp = "";
                } else {
                    temp = temp + ch;
                }
            }

            if (temp.length() > 0) {
                result.add(temp);
            }
        }

        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution obj = new Solution();

        List<String> words1 = new ArrayList<>();
        words1.add("one.two.three");
        words1.add("four.five");
        words1.add("six");

        System.out.println(obj.splitWordsBySeparator(words1, '.'));
        // Output: [one, two, three, four, five, six]

        List<String> words2 = new ArrayList<>();
        words2.add("$easy$");
        words2.add("$problem$");

        System.out.println(obj.splitWordsBySeparator(words2, '$'));
        // Output: [easy, problem]

        List<String> words3 = new ArrayList<>();
        words3.add("|||");

        System.out.println(obj.splitWordsBySeparator(words3, '|'));
        // Output: []
    }
}
