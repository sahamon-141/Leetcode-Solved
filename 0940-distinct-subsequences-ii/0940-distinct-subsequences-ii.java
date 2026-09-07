class Solution {

    static final int MOD = 1_000_000_007;

    public int solve(
        int index,
        String s,
        int[] next,
        long[] dp
    ) {

        // No characters left
        // The empty subsequence is one possibility
        if (index == s.length()) {
            return 1;
        }

        // Already calculated
        if (dp[index] != -1) {
            return (int) dp[index];
        }

        /*
            We choose the current character.

            Suppose s[index] = 'a'.

            If we take this 'a', then after taking it,
            we can continue from the NEXT occurrence of each
            character.

            Instead of generating strings, we count them.
        */

        long ans = 1; // Count the subsequence containing s[index]

        /*
            Try choosing each possible character as the
            next character in our subsequence.

            next[index * 26 + c] gives the first occurrence
            of character c at or after index.
        */
        for (int c = 0; c < 26; c++) {

            int nextIndex = next[index * 26 + c];

            if (nextIndex != -1) {

                /*
                    Choose this character.

                    solve(nextIndex + 1) gives all possibilities
                    after choosing this character.
                */
                ans += solve(
                    nextIndex + 1,
                    s,
                    next,
                    dp
                );

                ans %= MOD;
            }
        }

        dp[index] = ans;

        return (int) ans;
    }

    public int distinctSubseqII(String s) {

        int n = s.length();

        /*
            next[i][c] = first position >= i
                        where character c occurs.

            We flatten the 2D array into a 1D array:
            
            next[i * 26 + c]
        */
        int[] next = new int[n * 26];

        Arrays.fill(next, -1);

        int[] last = new int[26];

        Arrays.fill(last, -1);

        /*
            Build the next-occurrence table from right to left.
        */
        for (int i = n - 1; i >= 0; i--) {

            // Copy information from i+1
            if (i < n - 1) {
                for (int c = 0; c < 26; c++) {
                    next[i * 26 + c] =
                        next[(i + 1) * 26 + c];
                }
            }

            // Current character occurs at i
            int c = s.charAt(i) - 'a';

            next[i * 26 + c] = i;
        }

        /*
            dp[i] = number of distinct subsequences
                    that can be formed starting from index i.

            -1 means not calculated yet.
        */
        long[] dp = new long[n + 1];

        Arrays.fill(dp, -1);

        /*
            solve(0) includes the empty subsequence.

            Therefore subtract 1.
        */
        return (solve(0, s, next, dp) - 1 + MOD) % MOD;
    }
}