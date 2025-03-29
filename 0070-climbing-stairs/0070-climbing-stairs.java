class Solution {
    public int helper(int [] memo, int n){
        if( n == 0) return 1;

        if(memo[n] != 0){
            return memo[n];
        }

        memo[n] = helper(memo, n-1) + helper(memo, n-2);
        return memo[n];


    }
    public int climbStairs(int n) {
        // int [] dp = new int[n+1];

        // dp[0] = 1;

        // for(int i=1; i<dp.length; i++){
        //     if( i == 1){
        //         dp[i] = dp[i-1] + 0;
        //         continue;
        //     }

        //     dp[i] = dp[i-1] + dp[i-2];
        // }

        // return dp[n];
        int [] memo = new int[n+1];
        memo[0] = 1;
        memo[1] = 1;
        return helper(memo, n);
    }
}