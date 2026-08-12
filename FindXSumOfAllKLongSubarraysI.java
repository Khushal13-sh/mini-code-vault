/*
Find X-Sum of All K-Long Subarrays I
Difficulty: Easy

Description:
Given an array nums of n integers and two integers k and x.

The x-sum of an array is calculated by:
1. Count the occurrences of all elements in the array.
2. Keep only the occurrences of the top x most frequent elements.
   If two elements have the same number of occurrences, 
   the element with the bigger value is considered more frequent.
3. Calculate the sum of the resulting array.
   If an array has less than x distinct elements, 
   its x-sum is the sum of the array.

Return an integer array answer of length n - k + 1 where answer[i] 
is the x-sum of the subarray nums[i..i + k - 1].

Key Insight:
- For each sliding window of size k, count frequencies of elements.
- Sort elements by (frequency, value) in descending order.
- Sum the top x elements (or all if less than x distinct).
- Since constraints are small (n <= 50, nums[i] <= 50), 
  a straightforward approach works efficiently.

Approach:
1. Iterate through each subarray of length k.
2. Create a frequency array of size 51 (since nums[i] <= 50).
3. Count frequencies for the current subarray.
4. Collect all distinct elements with their frequencies.
5. Sort them by frequency (descending), then by value (descending).
6. Take the top x elements and calculate their sum.
7. Store the result in the answer array.

Why this works:
The constraints are small, so O(n * k * log(k)) is acceptable.
The sorting ensures we correctly select the top x most frequent elements.

Time Complexity: O((n-k+1) * (k + distinct * log(distinct)))
Space Complexity: O(51) for frequency array + O(distinct) for elements list
*/

import java.util.*;

public class FindXSumOfAllKLongSubarraysI {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] answer = new int[n - k + 1];
        
        // Iterate through each subarray
        for (int i = 0; i <= n - k; i++) {
            // Count frequencies in current subarray
            int[] freq = new int[51]; // since nums[i] <= 50
            for (int j = i; j < i + k; j++) {
                freq[nums[j]]++;
            }
            
            // Create list of distinct elements with their frequencies
            List<int[]> elements = new ArrayList<>();
            for (int val = 1; val <= 50; val++) {
                if (freq[val] > 0) {
                    elements.add(new int[]{val, freq[val]});
                }
            }
            
            // Sort by frequency (descending), then by value (descending)
            Collections.sort(elements, (a, b) -> {
                if (a[1] != b[1]) {
                    return b[1] - a[1]; // higher frequency first
                }
                return b[0] - a[0]; // higher value first
            });
            
            // Calculate x-sum
            int sum = 0;
            int count = Math.min(x, elements.size());
            for (int idx = 0; idx < count; idx++) {
                int val = elements.get(idx)[0];
                int freqCount = elements.get(idx)[1];
                sum += val * freqCount;
            }
            
            answer[i] = sum;
        }
        
        return answer;
    }

    public static void main(String[] args) {
        FindXSumOfAllKLongSubarraysI solution = new FindXSumOfAllKLongSubarraysI();
        
        // Example 1
        int[] nums1 = {1, 1, 2, 2, 3, 4, 2, 3};
        int k1 = 6, x1 = 2;
        int[] result1 = solution.findXSum(nums1, k1, x1);
        System.out.println("Example 1 Output: " + Arrays.toString(result1));
        // Expected: [6, 10, 12]
        
        // Example 2
        int[] nums2 = {3, 8, 7, 8, 7, 5};
        int k2 = 2, x2 = 2;
        int[] result2 = solution.findXSum(nums2, k2, x2);
        System.out.println("Example 2 Output: " + Arrays.toString(result2));
        // Expected: [11, 15, 15, 15, 12]
        
        // Additional test case
        int[] nums3 = {5, 5, 5, 5};
        int k3 = 3, x3 = 2;
        int[] result3 = solution.findXSum(nums3, k3, x3);
        System.out.println("Example 3 Output: " + Arrays.toString(result3));
        // Expected: [15, 15]
    }
}