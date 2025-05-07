class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int [][] dp = new int[n][n];

        // single character is always palindromic
        for(int i=0; i<dp.length; i++){
            dp[i][i] = 1;
        }

        for(int len = 2; len<=n; len++){
            for(int i=0; i<=n-len; i++){
                int j = i+len-1;

                //Both character same hence palindromic
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2+dp[i+1][j-1];
                }
                //else not
                else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }

            }
        }

        return dp[0][n-1];
    }
}