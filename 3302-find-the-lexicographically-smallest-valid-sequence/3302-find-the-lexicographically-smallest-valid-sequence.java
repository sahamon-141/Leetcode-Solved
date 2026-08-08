import java.util.Arrays;

class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] last = new int[m];
        Arrays.fill(last, -1);
        
        int i = n - 1;
        int j = m - 1;
        
        while (i >= 0 && j >= 0) {
            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }
            i--;
        }
        
        int[] ans = new int[m];
        boolean canChange = true;
        j = 0; 
    
        for (i = 0; i < n; ++i) {
            if (j == m) {
                break;
            }
            
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                j++;
            } 
            else if (canChange && (j + 1 == m || last[j + 1] > i)) {
                canChange = false;
                ans[j] = i;
                j++;
            }
        }
        if (j == m) {
            return ans;
        }
        
        return new int[0];
    }
}
