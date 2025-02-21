class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0, prev_count = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1 && i != nums.length -1){
                count ++;
            }
            if(nums[i] == 0){
                if(count >= prev_count){
                    prev_count = count;
                    count = 0;
                }else{
                    count = 0;
                }
            }
            if(nums[i] == 1 && i==nums.length-1){
                count++;
                if(count >= prev_count){
                    prev_count = count;
                    // count = 0;/
                }
            }
        }

        return prev_count;
    }
}