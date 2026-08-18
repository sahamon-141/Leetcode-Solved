import java.util.*;

class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        
        // Count total global occurrences of each number
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Case 1: Window size is 1. Return the largest unique element globally.
        if (k == 1) {
            int max = -1;
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() == 1) {
                    max = Math.max(max, entry.getKey());
                }
            }
            return max;
        }

        // Case 2: Window size equals array size. Return the absolute maximum element.
        if (k == n) {
            int max = -1;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }

        // Case 3: 1 < k < n. Only first or last elements can belong to exactly 1 window.
        int max = -1;
        if (countMap.get(nums[0]) == 1) {
            max = Math.max(max, nums[0]);
        }
        if (countMap.get(nums[n - 1]) == 1) {
            max = Math.max(max, nums[n - 1]);
        }

        return max;
    }
}
