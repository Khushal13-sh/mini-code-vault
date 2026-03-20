/**
 * ------------------------------------------------------------
 * Problem : Redistribute Characters to Make All Strings Equal
 * Class   : EqualStringRedistributor
 * ------------------------------------------------------------
 */

public class EqualStringRedistributor {

    public boolean makeEqual(String[] words) {

        int[] freq = new int[26];

        // Count total frequency of each character
        for (String word : words) {
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
        }

        int n = words.length;

        // Check divisibility
        for (int count : freq) {
            if (count % n != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        EqualStringRedistributor obj = new EqualStringRedistributor();

        // Example 1
        String[] words1 = {"abc","aabc","bc"};
        System.out.println("Output: " + obj.makeEqual(words1));
        // Expected: true

        // Example 2
        String[] words2 = {"ab","a"};
        System.out.println("Output: " + obj.makeEqual(words2));
        // Expected: false
    }
}