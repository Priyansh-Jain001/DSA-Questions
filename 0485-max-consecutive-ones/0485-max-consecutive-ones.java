class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0, prev_count = 0;

        // for(int i=0; i<nums.length; i++){
        //     if(nums[i] == 1 && i != nums.length -1){ //Edge Case
        //         count++;
        //     }

        //     if(nums[i] == 0){
        //         if(count >= prev_count){
        //             prev_count = count;
        //             count = 0;
        //         }else{
        //             count = 0;
        //         }
        //     }

        //     if(nums[i] == 1 && i==nums.length-1){ //Edge Case
        //         count++;
        //         if(count >= prev_count){
        //             prev_count = count;
        //             // count = 0;/
        //         }
        //     }
        // }

        // return prev_count;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                count++;
            }
            else{
                prev_count = Math.max(count,prev_count);
                count = 0;
            }
        }

        return Math.max(count, prev_count);
    }
}