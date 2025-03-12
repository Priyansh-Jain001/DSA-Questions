class Solution {
    public void moveZeroes(int[] nums) {
        int lastNonZeroIdx = 0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]!=0){
        //         nums[lastNonZeroIdx]  = nums[i];
        //         lastNonZeroIdx++;
        //     }
        // }
        // for(int i= lastNonZeroIdx; i<nums.length; i++){
        //     nums[i] = 0;
        // }

       for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
            // Swap elements if the current index is different from lastNonZeroIdx
            if (i != lastNonZeroIdx) {
                int temp = nums[i];
                nums[i] = nums[lastNonZeroIdx];
                nums[lastNonZeroIdx] = temp;
            }
            lastNonZeroIdx++;
        }
    }
    }
}