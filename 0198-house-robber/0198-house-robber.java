class Solution {
    public int rob(int[] nums) {
        int prev1 = 0;
        int prev2 = 0;
        for(int curr:nums){
            int max = Math.max(prev2+curr,prev1);
            prev2 = prev1;
            prev1 = max;
        }
        return prev1;
    }
}