/**
 * ------------------------------------------------------------
 * Class Name : RemoveLetterToEqualizeFrequency
 *
 * Description :
 * Checks whether removing exactly one character from
 * the string can make all remaining character
 * frequencies equal.
 *
 * ------------------------------------------------------------
 */
public class RemoveLetterToEqualizeFrequency {

    /**
     * Returns true if one removal can equalize frequencies.
     */
    public boolean equalFrequency(String word) {

        int[] freq = new int[26];

        // Count frequency of each letter
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        // Try removing one occurrence of each letter
        for (int i = 0; i < 26; i++) {

            if (freq[i] == 0) continue;

            freq[i]--;

            if (allEqual(freq)) {
                return true;
            }

            freq[i]++; // restore
        }

        return false;
    }

    /**
     * Checks if all non-zero frequencies are equal.
     */
    private boolean allEqual(int[] freq) {

        int target = 0;

        for (int f : freq) {

            if (f == 0) continue;

            if (target == 0) {
                target = f;
            } else if (target != f) {
                return false;
            }
        }

        return true;
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {
        RemoveLetterToEqualizeFrequency solution = new RemoveLetterToEqualizeFrequency();

        System.out.println(solution.equalFrequency("abcc")); // true
        System.out.println(solution.equalFrequency("aazz")); // false
    }
}
