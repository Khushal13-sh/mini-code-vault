/**
 * Problem: Odd String Difference
 * Difficulty: Easy
 *
 * Find the string whose difference array
 * is different from all others.
 */
public class OddStringDifference {

    public String oddString(String[] words) {

        int[] d0 = diff(words[0]);
        int[] d1 = diff(words[1]);
        int[] d2 = diff(words[2]);

        // Identify the common difference array
        int[] common = equals(d0, d1) ? d0 : equals(d0, d2) ? d0 : d1;

        // Check first two explicitly
        if (!equals(d0, common)) return words[0];
        if (!equals(d1, common)) return words[1];

        // Check remaining words
        for (int i = 2; i < words.length; i++) {
            if (!equals(diff(words[i]), common)) {
                return words[i];
            }
        }

        return "";
    }

    // Computes difference array of a string
    private int[] diff(String s) {
        int[] d = new int[s.length() - 1];
        for (int i = 0; i < d.length; i++) {
            d[i] = s.charAt(i + 1) - s.charAt(i);
        }
        return d;
    }

    // Compares two integer arrays
    private boolean equals(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    // Main method for testing
    public static void main(String[] args) {
        OddStringDifference obj =
                new OddStringDifference();

        System.out.println(obj.oddString(
                new String[]{"adc","wzy","abc"})); // abc

        System.out.println(obj.oddString(
                new String[]{"aaa","bob","ccc","ddd"})); // bob
    }
}
