class Solution {
    public int findMin(int[] nums) {
        int st =0, end = nums.length-1;
        int min = Integer.MAX_VALUE;

        while(st<=end){
            int mid = st + (end - st)/2;
            
            // full array is sorted
            if(nums[st] <= nums[end]){    
                min = Math.min(min, nums[st]);
                break;
            }

            // left half of the array is sorted
            if(nums[st] <= nums[mid]){      
                min = Math.min(min, nums[st]);
                st = mid + 1;
            }
            
            // right half of the array is sorted
            else{                         
                min = Math.min(min, nums[mid]);
                end = mid - 1;
            }
        }   
        return min;
    }
}