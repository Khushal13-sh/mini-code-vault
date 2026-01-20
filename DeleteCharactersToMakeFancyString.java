/**
 * Problem: Delete Characters to Make Fancy String
 * Difficulty: Easy
 *
 * Ensure no three consecutive characters are equal
 * using a greedy StringBuilder approach.
 */
class DeleteCharactersToMakeFancyString {

    public String makeFancyString(String s) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int len = result.length();

            // Skip if adding this character causes 3 consecutive same chars
            if (len >= 2 &&
                result.charAt(len - 1) == s.charAt(i) &&
                result.charAt(len - 2) == s.charAt(i)) {
                continue;
            }

            result.append(s.charAt(i));
        }

        return result.toString();
    }

    // Example test cases
    public static void main(String[] args) {
        DeleteCharactersToMakeFancyString obj =
                new DeleteCharactersToMakeFancyString();

        System.out.println(obj.makeFancyString("leeetcode")); // leetcode
        System.out.println(obj.makeFancyString("aaabaaaa"));  // aabaa
        System.out.println(obj.makeFancyString("aab"));       // aab
    }
}
