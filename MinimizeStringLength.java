/**
 * Problem: Minimize String Length
 * Difficulty: Easy
 *
 * The minimum possible length equals the number
 * of distinct characters in the string.
 */
class MinimizeStringLength {

    public int minimizedStringLength(String s) {

        boolean[] seen = new boolean[26];

        // Mark unique characters
        for (char c : s.toCharArray()) {
            seen[c - 'a'] = true;
        }

        // Count distinct characters
        int count = 0;
        for (boolean b : seen) {
            if (b) count++;
        }

        return count;
    }

    // Example test cases
    public static void main(String[] args) {
        MinimizeStringLength obj = new MinimizeStringLength();

        System.out.println(obj.minimizedStringLength("aaabc"));    // 3
        System.out.println(obj.minimizedStringLength("cbbd"));     // 3
        System.out.println(obj.minimizedStringLength("baadccab")); // 4
    }
}
