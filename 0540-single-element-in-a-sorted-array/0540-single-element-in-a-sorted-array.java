class Solution {
    public int singleNonDuplicate(int[] nums) {
        // Edge Cases
        if(nums.length == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[nums.length-1] != nums[nums.length-2]) return nums[nums.length-1];

        int st = 1, end = nums.length-2;    
        while(st<=end){
            int mid = st + (end-st)/2;

            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) return nums[mid];

        // considering 0 as even
            if(mid%2 == 0 && nums[mid] == nums[mid+1] || mid%2 == 1 && nums[mid] == nums[mid-1]){
                // Eliminate Left half
                st = mid + 1;
            }
            else{
                // Eliminate right half
                end = mid - 1;
            }
        }

        // Dummy return
        return -1;
    }
}