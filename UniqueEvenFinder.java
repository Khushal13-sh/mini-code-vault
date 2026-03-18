import java.util.HashMap;
import java.util.Map;

/**
 * ------------------------------------------------------------
 * Problem : First Unique Even Element
 * Class   : UniqueEvenFinder
 * ------------------------------------------------------------
 */

public class UniqueEvenFinder {

    public int firstUniqueEven(int[] nums) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Find first unique even
        for (int num : nums) {
            if (num % 2 == 0 && freqMap.get(num) == 1) {
                return num;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        UniqueEvenFinder obj = new UniqueEvenFinder();

        // Example 1
        int[] nums1 = {3,4,2,5,4,6};
        System.out.println("Output: " + obj.firstUniqueEven(nums1));
        // Expected: 2

        // Example 2
        int[] nums2 = {4,4};
        System.out.println("Output: " + obj.firstUniqueEven(nums2));
        // Expected: -1
    }
}