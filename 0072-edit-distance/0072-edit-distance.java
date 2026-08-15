import java.util.Arrays;

class Solution { 
    public static int solve(int m, int n, String word1, String word2, int[][] dp) { 
        if (m < 0) return n + 1; 
        if (n < 0) return m + 1; 
        if (dp[m][n] != -1) return dp[m][n];
        if (word1.charAt(m) == word2.charAt(n)) {
            return dp[m][n] = solve(m - 1, n - 1, word1, word2, dp);
        } else { 
            int insert  = 1 + solve(m, n - 1, word1, word2, dp); 
            int delete  = 1 + solve(m - 1, n, word1, word2, dp); 
            int replace = 1 + solve(m - 1, n - 1, word1, word2, dp); 
            return dp[m][n] = Math.min(insert, Math.min(delete, replace)); 
        } 
    } 

    public int minDistance(String word1, String word2) { 
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(m - 1, n - 1, word1, word2, dp); 
    } 
}
