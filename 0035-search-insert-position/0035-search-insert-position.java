class Solution {
    public int searchInsert(int[] nums, int target) {
        int st = 0, end = nums.length-1, result = -1;

        while(st<=end){
            int mid = st + (end-st)/2;
            if(target == nums[mid]) return mid;

            else if(target>nums[mid]){
                result = mid;
                st = mid+1;
            }else{
                end = mid-1;
            }
        }

        return result+1;
    }
}