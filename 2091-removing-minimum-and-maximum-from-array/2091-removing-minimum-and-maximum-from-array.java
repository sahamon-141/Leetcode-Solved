class Solution {
    public int minimumDeletions(int[] nums) {

        int n = nums.length;

        int minindex = -1;
        int maxindex = -1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Find minimum and maximum values and their indices
        for (int i = 0; i < n; i++) {

            if (nums[i] > max) {
                max = nums[i];
                maxindex = i;
            }

            if (nums[i] < min) {
                min = nums[i];
                minindex = i;
            }
        }

        // Smaller and larger of the two indices
        int left = Math.min(minindex, maxindex);
        int right = Math.max(minindex, maxindex);

        // Option 1: Remove both from the left
        int removeFromLeft = right + 1;

        // Option 2: Remove both from the right
        int removeFromRight = n - left;

        // Option 3: Remove one from left and the other from right
        int removeBothSides = (left + 1) + (n - right);

        // Choose the minimum
        return Math.min(
            removeFromLeft,
            Math.min(removeFromRight, removeBothSides)
        );
    }
}