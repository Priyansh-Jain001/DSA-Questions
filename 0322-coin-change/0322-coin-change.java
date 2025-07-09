class Solution {
    public int coinChange(int[] coins, int amount) {
    //     Arrays.sort(coins);
    //     int ans = 0;

    //     for(int i=coins.length-1 ;i>=0; i--){
    //         while(amount >= coins[i]){
    //             amount = amount - coins[i];
    //             ans += 1;
    //         }
    //     }

    //     if(amount == 0){
    //         return ans;
    //     }else{
    //         return -1;
    //     }
    // }

    int [][] dp = new int[coins.length+1][amount+1];

    for(int i=0; i<coins.length; i++){
        dp[i][0] = 0;
    }

    // with 0 (no coin) coins we cannot make any amounti.e it is impossible to make any amount with 0 coins i.e infinity.
    for(int j=1; j<amount+1; j++){
        dp[0][j] = Integer.MAX_VALUE - 1; // or a large number to         represent "impossible"
    }
   

    for(int i=1; i<dp.length; i++){
        for(int j=1; j<dp[i].length; j++){
            int val = coins[i-1];

            if(val <= j){
                // include
                int ans1 = 1 + dp[i][j-val];
                //exclude
                int ans2 = dp[i-1][j];
                dp[i][j] = Math.min(ans1, ans2);
            }
            else{
                dp[i][j] = dp[i-1][j];
            }
        }
    }

    return dp[coins.length][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[coins.length][amount];

}

}