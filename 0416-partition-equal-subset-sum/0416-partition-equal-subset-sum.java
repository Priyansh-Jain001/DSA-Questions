class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int i: nums){
            sum += i;
        }

        if(sum%2 != 0){
            return false;
        }

        int target = sum/2;
        
        boolean [][] dp = new boolean[nums.length +1][target+1];

        for(int i=0; i<dp.length; i++){
            dp[i][0] = true;
        }

        for(int i=1; i<dp.length; i++){
            for(int j =1; j<dp[i].length; j++){
                int v = nums[i-1];

                if(v <= j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-v];
                }else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }

        return dp[nums.length][target];
    }
}