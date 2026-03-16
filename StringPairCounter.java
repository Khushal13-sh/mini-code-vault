import java.util.HashSet;

/**
 * ------------------------------------------------------------
 * Problem : Find Maximum Number of String Pairs
 * Class   : StringPairCounter
 * ------------------------------------------------------------
 */

public class StringPairCounter {

    public int maximumNumberOfStringPairs(String[] words) {

        HashSet<String> set = new HashSet<>();
        int count = 0;

        for (String word : words) {

            String reversed = new StringBuilder(word).reverse().toString();

            if (set.contains(reversed)) {
                count++;
                set.remove(reversed);
            } else {
                set.add(word);
            }
        }

        return count;
    }

    public static void main(String[] args) {

        StringPairCounter obj = new StringPairCounter();

        // Example 1
        String[] words1 = {"cd","ac","dc","ca","zz"};
        System.out.println("Output: " + obj.maximumNumberOfStringPairs(words1));
        // Expected: 2

        // Example 2
        String[] words2 = {"ab","ba","cc"};
        System.out.println("Output: " + obj.maximumNumberOfStringPairs(words2));
        // Expected: 1

        // Example 3
        String[] words3 = {"aa","ab"};
        System.out.println("Output: " + obj.maximumNumberOfStringPairs(words3));
        // Expected: 0
    }
}