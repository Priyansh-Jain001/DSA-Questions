class Solution {

    // Brute Force Approach TC=O(n^3)
    
    /*public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i=0; i<nums.length; i++){
            for(int j=i; j<nums.length; j++){
                for(int k=i; k<=j; k++){
                    currSum+=nums[k];
                }

                if(currSum > max){
                    max = currSum;
                }
                currSum=0;
            }
        }

         return max;
    }
    */

    // Kadane's Algorithm
    public int maxSubArray(int[] nums){
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        boolean flag = false;

        for(int i: nums){
            if(i>0) flag = true;
        }

        if(flag){
          for(int i=0; i<nums.length; i++){
            currSum += nums[i];

            if(currSum<0){
                currSum = 0;
            }

            max = Math.max(currSum, max);
            }
        }else{
            for(int i:nums){
                max = Math.max(max, i);
            }
        }  
        
        

        return max;
    }
}