class Solution {
    public int solve(String s,String t,int i,int j,int[][] dp){
        if(j<0) return 1;//all the characters in t are matched with s 
        if(i<0) return 0; //the characters in s is exhausted and still something is left in t
        if(dp[i][j]!=-1){return dp[i][j];}
        if(s.charAt(i)==t.charAt(j)){
            int matchcurrent = solve(s,t,i-1,j-1,dp);
            int skipthisone = solve(s,t,i-1,j,dp);
            dp[i][j] = matchcurrent + skipthisone;
            return dp[i][j];
        }
        dp[i][j] = solve(s,t,i-1,j,dp);
        return dp[i][j];
        
    }
    public int numDistinct(String s, String t) {
        int [][] dp = new int[s.length()+1][t.length()+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(s,t,s.length()-1,t.length()-1,dp);
    }
}