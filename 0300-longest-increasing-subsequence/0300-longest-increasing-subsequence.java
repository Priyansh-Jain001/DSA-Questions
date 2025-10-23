class Solution {
    public int lengthOfLIS(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i: nums){
            set.add(i);
        }

        int [] arr = new int[set.size()];
        int k = 0;
        for(int i: set){
            arr[k] = i;
            k++;
        }
        Arrays.sort(arr);
        
        int [][] dp = new int[nums.length+1][arr.length+1];

        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0;
        }

        for(int j=0; j<dp[0].length; j++){
            dp[0][j] = 0;
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[i].length; j++){
                if(nums[i-1] == arr[j-1]){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[nums.length][arr.length];
    }
}