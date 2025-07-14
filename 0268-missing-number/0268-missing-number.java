class Solution {
    /*
    // Time Complexity = O(n.log(n))
    public int missingNumber(int[] nums) {

        Arrays.sort(nums);

        if(nums.length == 1){
            if(nums[nums.length-1]==0){
                return 1;
            }else{
                return 0;
            }
        }


        for(int i=0;i<nums.length-1; i++){
            if(nums[0] != 0){
                return 0;
            }
            if(nums[i+1] != nums[i]+1){
                return nums[i]+1;
            }
        }
        return nums[nums.length-1]+1;
    }
    */

// Time Complexity = O(n)
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }

        int totalSum = (n*(n+1))/2;

        return totalSum - sum;
    }
}