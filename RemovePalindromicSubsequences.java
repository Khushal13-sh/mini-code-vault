/**
 * Problem: Remove Palindromic Subsequences
 * Difficulty: Easy
 *
 * 🎯 Goal:
 * You are given a string `s` consisting only of letters 'a' and 'b'.
 * You can remove any palindromic subsequence in one step.
 * Return the minimum number of steps to make the string empty.
 *
 * ✅ Key Observations:
 * 1. If the string itself is a palindrome → return 1 (remove whole string).
 * 2. If it's not a palindrome → return 2 (remove all 'a's and all 'b's separately).
 *
 * 🔁 Note:
 * - A subsequence doesn't need to be continuous.
 * - A palindrome reads the same forwards and backwards.
 *
 * 📘 Examples:
 * Input: "ababa" → Output: 1 (entire string is palindrome)
 * Input: "abb"   → Output: 2 (remove "a", then "bb")
 * Input: "baabb" → Output: 2 (remove "baab", then "b")
 */

public class RemovePalindromicSubsequences {

    public static int removePalindromeSub(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return 2; // not a palindrome
            }
            left++;
            right--;
        }

        return 1; // string is a palindrome
    }

    public static void main(String[] args) {
        System.out.println("Result: " + removePalindromeSub("ababa")); // 1
        System.out.println("Result: " + removePalindromeSub("abb"));   // 2
        System.out.println("Result: " + removePalindromeSub("baabb")); // 2
        System.out.println("Result: " + removePalindromeSub("a"));     // 1
    }
}
