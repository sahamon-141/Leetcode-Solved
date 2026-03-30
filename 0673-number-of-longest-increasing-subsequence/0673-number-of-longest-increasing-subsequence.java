class Solution {
    public int findNumberOfLIS(int[] nums) {
      int n = nums.length;
        int[] count = new int[n];
        int[] len = new int[n];
        int finalcount = 0;
        int maxlen = 0;
        Arrays.fill(count,1);
        Arrays.fill(len,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if (len[j] + 1 > len[i]) {
    len[i] = len[j] + 1;   // found a longer subsequence
    count[i] = count[j];   // inherit that count
}
else if (len[j] + 1 == len[i]) {
    count[i] += count[j];  // same length → add to count
}
                }
            }
            maxlen = Math.max(maxlen,len[i]);
        }
        for(int i=0;i<n;i++){
            if(len[i]==maxlen){
                finalcount+=count[i];
            }
        }
        return finalcount;  
    }
}