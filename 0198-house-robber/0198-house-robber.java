class Solution {

// time complexity O(n^2)
    public int[] robHelper(int [] arr, int [] nums){
        arr[0] = nums[0];
        arr[1] = nums[1];

        for(int i=2; i<nums.length; i++){
            int max = Integer.MIN_VALUE;
            int j = i-2;
            while(j>=0){
                max = Math.max(max, nums[i] + arr[j]);
                j--;
            }

            arr[i] = max;
        }
        return arr;
    }

    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int [] arr = new int[nums.length];
        int [] ans = robHelper(arr, nums);

        int max = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    } 


    // time complexity O(n)
    /*
    public int rob(int [] nums){
        int [] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[nums.length - 1];
    }
    */
}