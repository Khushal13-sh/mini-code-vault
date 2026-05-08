/*
 add solution for check if strings can be made equal with operations using index parity swapping
*/

/**
 * Problem: Check if Strings Can be Made Equal With Operations I
 * Difficulty: Easy
 *
 * Description:
 * You can swap characters only between indices having difference 2.
 * Determine whether s1 can be transformed into s2.
 *
 * Key Insight:
 * - Index 0 can swap with index 2
 * - Index 1 can swap with index 3
 * - Even indexed characters remain among even positions
 * - Odd indexed characters remain among odd positions
 *
 * Approach:
 * - Compare even indexed characters separately
 * - Compare odd indexed characters separately
 * - Since swapping is allowed within parity groups,
 *   order inside each group does not matter
 *
 * Why this works:
 * Allowed swaps only rearrange characters
 * inside even positions and inside odd positions.
 * If both groups match, transformation is possible.
 *
 * Time Complexity: O(1)
 *
 * Space Complexity: O(1)
 */
public class CheckStringsEqualOperations {

    public boolean canBeEqual(String s1, String s2) {

        // Even indexed characters from s1
        char a1 = s1.charAt(0);
        char a2 = s1.charAt(2);

        // Odd indexed characters from s1
        char b1 = s1.charAt(1);
        char b2 = s1.charAt(3);

        // Check even positions
        boolean even =
                (a1 == s2.charAt(0) && a2 == s2.charAt(2)) ||
                (a1 == s2.charAt(2) && a2 == s2.charAt(0));

        // Check odd positions
        boolean odd =
                (b1 == s2.charAt(1) && b2 == s2.charAt(3)) ||
                (b1 == s2.charAt(3) && b2 == s2.charAt(1));

        return even && odd;
    }

    public static void main(String[] args) {

        CheckStringsEqualOperations obj =
                new CheckStringsEqualOperations();

        // Example 1
        System.out.println(
                "Output 1: " +
                obj.canBeEqual("abcd", "cdab")
        ); // true

        // Example 2
        System.out.println(
                "Output 2: " +
                obj.canBeEqual("abcd", "dacb")
        ); // false
    }
}