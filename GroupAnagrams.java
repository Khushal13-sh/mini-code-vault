
import java.util.*;

/*
 * Problem: Group Anagrams
 *
 * Description:
 * Given an array of strings, group all strings
 * that are anagrams of each other.
 *
 * Approach: HashMap + Sorting
 *
 * Two strings are anagrams if they contain the
 * same characters with the same frequencies.
 *
 * Sorting the characters of anagrams produces
 * the same sorted string.
 *
 * We use this sorted string as the HashMap key
 * and store all matching original strings in a list.
 *
 * Time Complexity: O(n * k log k)
 * Space Complexity: O(n * k)
 *
 * n = Number of strings
 * k = Maximum length of a string
 */

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        // Key: Sorted string.
        // Value: List of original strings with that key.
        Map<String, List<String>> map = new HashMap<>();

        // Process every string in the input array.
        for (String str : strs) {

            // Convert the string into a character array.
            char[] chars = str.toCharArray();

            // Sort the characters alphabetically.
            Arrays.sort(chars);

            // Convert the sorted character array
            // into a string to use as the HashMap key.
            String key = new String(chars);

            // If this key does not exist,
            // create a new list for this group.
            if (!map.containsKey(key)) {

                map.put(key, new ArrayList<>());
            }

            // Add the original string to its
            // corresponding anagram group.
            map.get(key).add(str);
        }

        // Return all grouped lists.
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        GroupAnagrams solution = new GroupAnagrams();

        // Example 1
        String[] strs1 = {
            "eat", "tea", "tan", "ate", "nat", "bat"
        };

        System.out.println(solution.groupAnagrams(strs1));
        // Possible output:
        // [[eat, tea, ate], [tan, nat], [bat]]


        // Example 2: Empty string
        String[] strs2 = {""};

        System.out.println(solution.groupAnagrams(strs2));
        // Expected: [[""]]


        // Example 3: Single character
        String[] strs3 = {"a"};

        System.out.println(solution.groupAnagrams(strs3));
        // Expected: [["a"]]


        // Example 4: Multiple anagrams
        String[] strs4 = {"abc", "bca", "cab", "xyz", "zyx"};

        System.out.println(solution.groupAnagrams(strs4));
        // Possible output:
        // [[abc, bca, cab], [xyz, zyx]]
    }
}
