class Solution {
    public int solve(int ind,int buy,int n,int k,int[] prices,int[][][] dp){
        if(ind==n||k==0) return 0;
        int profit = 0;
        if(dp[ind][buy][k]!=-1) return dp[ind][buy][k];

        if(buy == 1){
            int take = -prices[ind] + solve(ind+1,0,n,k,prices,dp);
            int skip = solve(ind+1,1,n,k,prices,dp);
            profit = Math.max(take,skip);
        }
        else{
            int sell = prices[ind] + solve(ind+1,1,n,k-1,prices,dp);
            int skip = solve(ind+1,0,n,k,prices,dp);
            profit =  Math.max(sell,skip);
        }
        dp[ind][buy][k] = profit;
        return dp[ind][buy][k];
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0,1,n,k,prices,dp);

    }
}