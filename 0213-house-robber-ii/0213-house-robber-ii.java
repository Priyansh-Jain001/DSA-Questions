class Solution {

   public int robLinear(int[] nums, int st, int end) { // st and end inclusive
    int len = end - st + 1;
    if (len == 1) return nums[st];

    int[] dp = new int[len];
    dp[0] = nums[st];
    dp[1] = Math.max(nums[st], nums[st + 1]);

    for (int i = 2; i < len; i++) {
        dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[st + i]);
    }

    return dp[len - 1];
}


    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);

        int ans1 = robLinear(nums, 0, n-2);
        int ans2 = robLinear(nums, 1, n-1);

        return Math.max(ans1, ans2);
    } 
}