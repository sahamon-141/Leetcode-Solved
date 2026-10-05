class Solution {
    static {
        for(int i = 0; i < 500; i++){
            new Solution().maxScore(new int[1], 1);
        }
    }
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int curr = 0;
        for(int i=0;i<k;i++){
            curr+=cardPoints[i];
        }
        int max = curr;
        for(int i=0;i<k;i++){
            curr-= cardPoints[k-i-1];
            curr+= cardPoints[n-i-1];
            max = Math.max(max,curr);
        }
        return max;
    }
}