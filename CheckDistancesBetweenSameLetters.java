/**
 * ------------------------------------------------------------
 * Class Name : CheckDistancesBetweenSameLetters
 *
 * Description :
 * Checks whether the distance between two occurrences of
 * each letter in the string matches the given distance array.
 *
 * ------------------------------------------------------------
 */
public class CheckDistancesBetweenSameLetters {

    /**
     * Returns true if string is well-spaced, otherwise false.
     */
    public boolean checkDistances(String s, int[] distance) {
        int[] firstIndex = new int[26];

        // Initialize with -1 (means letter not seen yet)
        for (int i = 0; i < 26; i++) {
            firstIndex[i] = -1;
        }

        // Traverse the string
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';

            if (firstIndex[idx] == -1) {
                firstIndex[idx] = i; // store first occurrence
            } else {
                int actualDistance = i - firstIndex[idx] - 1;

                if (actualDistance != distance[idx]) {
                    return false; // mismatch found
                }
            }
        }

        return true;
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {
        CheckDistancesBetweenSameLetters solution = new CheckDistancesBetweenSameLetters();

        System.out.println(solution.checkDistances(
                "abaccb",
                new int[]{1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
        )); // true

        System.out.println(solution.checkDistances(
                "aa",
                new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
        )); // false
    }
}
