import java.util.*;

/**
 * Problem: Find the Difference of Two Arrays
 * Difficulty: Easy
 *
 * Given two integer arrays nums1 and nums2, return a list answer of size 2 where:
 *  - answer[0] is a list of all distinct integers in nums1 not present in nums2.
 *  - answer[1] is a list of all distinct integers in nums2 not present in nums1.
 *
 * Approach:
 * 1. Convert both arrays to HashSets to remove duplicates and allow O(1) lookups.
 * 2. Iterate over each set to find elements not present in the other set.
 * 3. Return the result as a list of lists.
 */
public class FindDifferenceOfTwoArrays {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);

        List<Integer> list1 = new ArrayList<>();
        for (int num : set1) {
            if (!set2.contains(num)) {
                list1.add(num);
            }
        }

        List<Integer> list2 = new ArrayList<>();
        for (int num : set2) {
            if (!set1.contains(num)) {
                list2.add(num);
            }
        }

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(list1);
        answer.add(list2);

        return answer;
    }

    public static void main(String[] args) {
        FindDifferenceOfTwoArrays solution = new FindDifferenceOfTwoArrays();

        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};
        System.out.println(solution.findDifference(nums1, nums2)); 
        // Expected: [[1, 3], [4, 6]]

        int[] nums3 = {1, 2, 3, 3};
        int[] nums4 = {1, 1, 2, 2};
        System.out.println(solution.findDifference(nums3, nums4)); 
        // Expected: [[3], []]
    }
}
