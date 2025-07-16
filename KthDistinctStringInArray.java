/**
 * Problem: Kth Distinct String in an Array
 * Difficulty: Easy
 *
 * Given an array of strings, return the k-th distinct string (appears exactly once).
 * If fewer than k distinct strings exist, return "".
 */

import java.util.*;

public class KthDistinctStringInArray {

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> countMap = new LinkedHashMap<>();

        for (String s : arr) {
            countMap.put(s, countMap.getOrDefault(s, 0) + 1);
        }

        for (String key : countMap.keySet()) {
            if (countMap.get(key) == 1) {
                k--;
                if (k == 0) {
                    return key;
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        KthDistinctStringInArray solution = new KthDistinctStringInArray();

        System.out.println(solution.kthDistinct(new String[]{"d", "b", "c", "b", "c", "a"}, 2)); // Output: "a"
        System.out.println(solution.kthDistinct(new String[]{"aaa", "aa", "a"}, 1));             // Output: "aaa"
        System.out.println(solution.kthDistinct(new String[]{"a", "b", "a"}, 3));                // Output: ""
    }
}
