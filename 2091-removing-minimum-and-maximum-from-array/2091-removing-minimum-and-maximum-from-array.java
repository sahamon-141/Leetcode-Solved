class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minindex = -1;
        int maxindex = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
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
        int left = Math.min(minindex, maxindex);
        int right = Math.max(minindex, maxindex);
        int removefromleft = right + 1;
        int removefromright = n - left;
        int removebothsides = (left + 1) + (n - right);
        return Math.min(removefromleft,Math.min(removefromright, removebothsides));
    }
}