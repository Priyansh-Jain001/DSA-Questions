class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
           return new int[] {-1,-1}; 
        }

        int st = 0, end = nums.length-1;

        while(st<=end){
            int mid = st + (end-st)/2;

            if(target == nums[mid]){
                while(st<=end){
                    if(nums[st] == target && nums[end] == target){
                        return new int[]{st, end};
                    }
                    else if(nums[st] == target){
                        end--;
                    }
                    else if(nums[end] == target){
                        st++;
                    }else{
                        end--;
                        st++;
                    } 
                }
            } 

            if(target < nums[mid]){
                end = mid-1;
            }else{
                st = mid+1;
            }
        }
         return new int[] {-1,-1};
    }
}