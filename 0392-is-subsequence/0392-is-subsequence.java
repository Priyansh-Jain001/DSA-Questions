class Solution {
    public int lcs(String s, String t){
        int n = s.length(), m=t.length();
        int [][] dp = new int[n+1][m+1];

        for(int i=0; i<n+1; i++){
            dp[i][0] = 0;
        }

        for(int j=0; j<m+1; j++){
            dp[0][j] = 0;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        return dp[n][m];
    }
    public boolean isSubsequence(String s, String t) {
        int lcs = lcs(s, t);
        if(lcs == s.length()){
            return true;
        }

        return false;
    }
}