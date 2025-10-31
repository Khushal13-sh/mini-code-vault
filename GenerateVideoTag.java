/**
 * Problem: Generate Tag for Video Caption
 * Difficulty: Easy
 *
 * Description:
 * You are given a string caption representing the caption for a video.
 * Perform the following steps to generate a valid tag:
 * 1. Combine all words into a single camelCase string prefixed with '#'.
 *    - The first word is lowercase.
 *    - The first letter of all subsequent words is uppercase.
 * 2. Remove all characters that are not English letters (except the initial '#').
 * 3. Truncate the tag to a maximum of 100 characters.
 *
 * Example 1:
 * Input: caption = "Leetcode daily streak achieved"
 * Output: "#leetcodeDailyStreakAchieved"
 *
 * Example 2:
 * Input: caption = "can I Go There"
 * Output: "#canIGoThere"
 *
 * Example 3:
 * Input: caption = "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"
 * Output: "#hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"
 *
 * Constraints:
 * 1 <= caption.length <= 150
 * caption consists only of English letters and spaces.
 */

public class GenerateVideoTag {

    public String generateTag(String caption) {
        if (caption == null || caption.isEmpty()) return "#";

        caption = caption.trim();
        StringBuilder tag = new StringBuilder("#");
        boolean newWord = true;
        boolean firstWord = true;

        for (int i = 0; i < caption.length(); i++) {
            char ch = caption.charAt(i);

            if (ch == ' ') {
                newWord = true;
                continue;
            }

            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                if (newWord) {
                    tag.append(firstWord ? Character.toLowerCase(ch) : Character.toUpperCase(ch));
                    newWord = false;
                    firstWord = false;
                } else {
                    tag.append(Character.toLowerCase(ch));
                }
            }
        }

        if (tag.length() > 100) tag.setLength(100);
        return tag.toString();
    }

    // Test examples
    public static void main(String[] args) {
        GenerateVideoTag sol = new GenerateVideoTag();

        System.out.println(sol.generateTag("Leetcode daily streak achieved"));
        // Expected: #leetcodeDailyStreakAchieved

        System.out.println(sol.generateTag("can I Go There"));
        // Expected: #canIGoThere

        System.out.println(sol.generateTag(
            "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"));
        // Expected: (truncated to 100 chars)
    }
}
