/**
 * Problem Title: Jewels and Stones
 * Difficulty: Easy
 * 
 * ✅ Problem Description:
 * You're given two strings:
 * - 'jewels' → represents the types of stones that are jewels
 * - 'stones' → represents the stones you have
 * 
 * Each character in 'stones' is a type of stone you possess.
 * You need to count how many of those are also jewels.
 * 
 * 🔹 Important:
 * - Letters are **case-sensitive** (i.e., 'a' ≠ 'A')
 * 
 * 📥 Example 1:
 * Input:  jewels = "aA", stones = "aAAbbbb"
 * Output: 3
 * Explanation: You have 3 jewels → 'a', 'A', 'A'
 * 
 * 📥 Example 2:
 * Input:  jewels = "z", stones = "ZZ"
 * Output: 0
 * 
 * 📌 Constraints:
 * - 1 <= jewels.length, stones.length <= 50
 * - Both strings contain only English letters
 * - All characters in 'jewels' are unique
 */

public class JewelsAndStones {

    /**
     * 🧠 Logic:
     * - Use a boolean array (size 128 for ASCII characters) to mark jewel characters.
     * - Iterate over 'stones', and count how many are marked as jewels.
     */
    public static int numJewelsInStones(String jewels, String stones) {
        boolean[] isJewel = new boolean[128];  // ASCII size

        // Mark jewel characters as true
        for (char c : jewels.toCharArray()) {
            isJewel[c] = true;
        }

        // Count how many stones are also jewels
        int count = 0;
        for (char c : stones.toCharArray()) {
            if (isJewel[c]) {
                count++;
            }
        }

        return count;
    }

    // 🧪 Main method to test the logic
    public static void main(String[] args) {
        String jewels1 = "aA", stones1 = "aAAbbbb";
        System.out.println("Output: " + numJewelsInStones(jewels1, stones1));  // Expected: 3

        String jewels2 = "z", stones2 = "ZZ";
        System.out.println("Output: " + numJewelsInStones(jewels2, stones2));  // Expected: 0
    }
}
