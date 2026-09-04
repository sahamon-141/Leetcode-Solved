class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int max[] = new int[n];
        int min[] = new int[n];
        int currmax = nums[0];
        max[0] = nums[0];
        for(int i=1;i<n;i++){
            if(currmax<nums[i]) currmax = nums[i];
            max[i] = currmax;
        }
        int currmin = nums[n-1];
        min[n-1] = currmin;
        for(int i=n-1;i>=0;i--){
            if(currmin>nums[i]) currmin = nums[i];
            min[i] = currmin;
        }
        boolean found = false;
        int minindex = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int diff = max[i]-min[i];
            if(diff<=k){
                found = true;
                minindex = Math.min(i,minindex);
            }
        }
        return !found?-1:minindex;
    }
}